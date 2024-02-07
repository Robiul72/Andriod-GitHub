package com.andriod.andriodproject.adepter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andriod.andriodproject.R;
import com.andriod.andriodproject.model.ClubModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ClubAdepter extends RecyclerView.Adapter<ClubAdepter.MemberViewHolder> {

    private List<ClubModel> memberList;

    private Context context;

    public ClubAdepter(List<ClubModel> memberList, Context context) {
        this.memberList = memberList;
        this.context = context;
    }

    @NonNull
    @Override
    public ClubAdepter.MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.member_details, parent, false);

        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubAdepter.MemberViewHolder holder, int position) {
        ClubModel member = memberList.get(position);

        holder.bind(member);

    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTextView;
        private TextView clubPositionTextView;
        private TextView address1TextView;
        private TextView address2TextView;
        private TextView phoneTextView;
        private TextView spouseNameTextView;
        private TextView membershipNoTextView;
        private TextView memberSinceTextView;
        private TextView bloodGroupTextView;
        private TextView districtPositionTextView;
        private TextView cellTextView;
        private TextView emailTextView;
        private ImageView memberImage;
        private ImageView spouseImag;
        private ImageView callButton;
        private ImageView emailButton;
        private ImageView textButton;

        public MemberViewHolder(@NonNull View itemView){

            super(itemView);

            nameTextView=itemView.findViewById(R.id.name);
            clubPositionTextView=itemView.findViewById(R.id.clubPosition);
            address1TextView=itemView.findViewById(R.id.address1);
            address2TextView=itemView.findViewById(R.id.address2);
            phoneTextView=itemView.findViewById(R.id.phone);
            spouseNameTextView=itemView.findViewById(R.id.spouseName);
            membershipNoTextView=itemView.findViewById(R.id.membershipNo);
            memberSinceTextView=itemView.findViewById(R.id.memberSince);
            bloodGroupTextView=itemView.findViewById(R.id.bloodGroup);
            districtPositionTextView=itemView.findViewById(R.id.districtPosition);
            cellTextView=itemView.findViewById(R.id.cell);
            emailTextView=itemView.findViewById(R.id.email);

            callButton=itemView.findViewById(R.id.call);
            emailButton=itemView.findViewById(R.id.mail);
            textButton=itemView.findViewById(R.id.message);


            memberImage=itemView.findViewById(R.id.memberImage);
            memberImage=itemView.findViewById(R.id.spouseImage);
        }


        public void bind(ClubModel member){

            nameTextView.setText("Name : " +member.getName());
            clubPositionTextView.setText("Name : " +member.getClubPosition());
            address1TextView.setText("Name : " +member.getAddress1());
            address2TextView.setText("Name : " +member.getAddress2());
            emailTextView.setText("Name : " +member.getEmail());
            phoneTextView.setText("Name : " +member.getPhone());
            cellTextView.setText("Name : " +member.getCell());
            spouseNameTextView.setText("Name : " +member.getSpouseName());
            membershipNoTextView.setText("Name : " +member.getMemberShipNo());
            memberSinceTextView.setText("Name : " +member.getMemberSince());
            bloodGroupTextView.setText("Name : " +member.getBloodGroup());
            districtPositionTextView.setText("Name : " +member.getBloodGroup());

           String relativeImagePathmember = member.getMemberImage();
           String baseUrlmember = "hhtp://purbachal.emranhss.com/";
           String imageUrlmember = baseUrlmember + relativeImagePathmember;

           String relativeImagePathspaouse = member.getSpouseImage();
           String baseUrlspaouse = "hhtp://purbachal.emranhss.com/";
           String imageUrlspaouse = baseUrlspaouse + relativeImagePathspaouse;

           Picasso.get().load(imageUrlmember).into(memberImage);
           Picasso.get().load(imageUrlspaouse).into(spouseImag);


           callButton.setOnClickListener(v->{
               try {
                   makeCall(member.getCell());
               } catch (Exception e){
                   e.printStackTrace();
               }
           });

           emailButton.setOnClickListener(v->{
               if(member !=null){
                   sendEmail(member.getEmail());
               }
           });

           textButton.setOnClickListener(v->{
               if(member !=null){
                   makeSMS(member.getCell());
               }
           });

        }

        private void makeSMS(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms : "+phoneNumber));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            itemView.getContext().startActivity(intent);
        }

        private void sendEmail(String emailAddress) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto : " + emailAddress));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            itemView.getContext().startActivity(intent);
        }

        private void makeCall(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel : "+phoneNumber));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            itemView.getContext().startActivity(intent);
        }
    }
}
