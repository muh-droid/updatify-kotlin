package com.muh.kotlin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class UpdateDialog {
    HashMap<String, Object> UpdatifyMap = new HashMap<>();
    SharedPreferences UCSP;
    AlertDialog updatifyDialog;
    com.google.android.material.bottomsheet.BottomSheetDialog updatifySheet;
    public void showDialog(String _response, Context context){

        try{
            //GET EVERYTHING READY
            String UpdatifyColorBack = "0";
            double UpdatifyRound = 60;
            String UpdatifyColor = "0";
            String UpdatifyCurrVer = "0";
            String UpdatifyTxtColor = "0";
            String UpdatifyBtnTxtColor = "0";

            //GET CURRENT VERSION
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            UpdatifyCurrVer = packageInfo.versionName;
            UpdatifyMap = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());

            //FILL DIALOG DATA

            String updatifyContent1 = (UpdatifyMap.get("dialogTitle").toString());
            String updatifyContent2 = (UpdatifyMap.get("dialogSubtitle").toString());
            String updatifyContent3 = (UpdatifyMap.get("dialogBtnExtraTxt").toString());
            String updatifyContent4 = (UpdatifyMap.get("dialogBtnMainTxt").toString());
            if (UpdatifyMap.get("dialogOption").toString().equals("warning")) {
                UpdatifyColor = "#BD081C";

                UpdatifyColorBack = "#FFFFFF";

                UpdatifyRound = 60;

                UpdatifyTxtColor = "#212121";

                UpdatifyBtnTxtColor = "#FFFFFF";
            } else {
                if (UpdatifyMap.get("dialogOption").toString().equals("update")) {
                    UpdatifyColor = "#0084FF";

                    UpdatifyColorBack = "#FFFFFF";

                    UpdatifyRound = 60;

                    UpdatifyTxtColor = "#212121";

                    UpdatifyBtnTxtColor = "#FFFFFF";
                }
                else {
                    if (UpdatifyMap.get("dialogOption").toString().equals("message")) {
                        UpdatifyColor = "#00B489";

                        UpdatifyColorBack = "#FFFFFF";

                        UpdatifyRound = 60;

                        UpdatifyTxtColor = "#212121";

                        UpdatifyBtnTxtColor = "#FFFFFF";
                    }
                    else {
                        UpdatifyColor = (UpdatifyMap.get("customDialogAccent").toString());

                        UpdatifyColorBack = (UpdatifyMap.get("customDialogBack").toString());

                        UpdatifyRound = Double.parseDouble(UpdatifyMap.get("customDialogRound").toString());

                        UpdatifyTxtColor = (UpdatifyMap.get("customDialogMainTxtColor").toString());

                        UpdatifyBtnTxtColor = (UpdatifyMap.get("customDialogBtnTxtColor").toString());
                    }
                }
            }
            if (!UpdatifyMap.containsKey("alertOption")) {
                UpdatifyMap.put("alertOption", "dialog");
            }
            //CREATE MAIN LAYOUT

            final LinearLayout main_layout = new LinearLayout(context);
            main_layout.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 0.0f));
            main_layout.setPadding(0,0,0,0);
            main_layout.setOrientation(LinearLayout.VERTICAL);
            main_layout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            //CHECK DIALOG OR SHEET

            if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {

                updatifySheet = new com.google.android.material.bottomsheet.BottomSheetDialog(context);
                updatifySheet.setContentView(main_layout);	updatifySheet.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);

            } else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {
                updatifyDialog = new AlertDialog.Builder(context).create();
                updatifyDialog.setView(main_layout);
                updatifyDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            }

            //CUSTOMIZE MAIN LAYOUT

            android.graphics.drawable.GradientDrawable wg1 = new android.graphics.drawable.GradientDrawable();
            wg1.setColor(Color.parseColor(UpdatifyColor));
            wg1.setCornerRadius(100);

            final LinearLayout linear_1 = new LinearLayout(context);
            linear_1.setLayoutParams(new LinearLayout.LayoutParams(175,175, 0.0f));
            linear_1.setPadding(0,0,0,0);
            linear_1.setOrientation(LinearLayout.VERTICAL);
            linear_1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            linear_1.setBackground(wg1);

            main_layout.addView(linear_1);

            android.graphics.drawable.GradientDrawable wg0 = new android.graphics.drawable.GradientDrawable();
            wg0.setColor(Color.parseColor(UpdatifyColorBack));
            wg0.setCornerRadius((float)UpdatifyRound);

            LinearLayout.LayoutParams lp1= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
            lp1.setMargins(40,0,40,0);
            final LinearLayout linear_55 = new LinearLayout(context);
            linear_55.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 0.0f));
            linear_55.setPadding(45,140,45,45);
            linear_55.setLayoutParams(lp1);
            linear_55.setOrientation(LinearLayout.VERTICAL);
            linear_55.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            linear_55.setBackground(wg0);
            main_layout.addView(linear_55);
            linear_55.setTranslationY((float)(-57.5d));
            //TITLE TEXTVIEW

            final TextView textview_3 = new TextView(context);
            textview_3.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 0.0f));
            textview_3.setPadding(0,0,0,0);
            textview_3.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            textview_3.setText(updatifyContent1);
            textview_3.setTextSize(16);
            textview_3.setTypeface(null, Typeface.BOLD);

            textview_3.setTextColor(Color.parseColor(UpdatifyTxtColor));
            textview_3.setSingleLine(true);
            linear_55.addView(textview_3);

            final LinearLayout linear_71 = new LinearLayout(context);
            linear_71.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,15, 0.0f));
            linear_71.setPadding(10,10,10,10);
            linear_71.setOrientation(LinearLayout.HORIZONTAL);
            linear_71.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            linear_55.addView(linear_71);
            //SUBTITLE TEXTVIEW

            final TextView textview_4 = new TextView(context);
            textview_4.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 0.0f));
            textview_4.setPadding(0,20,0,20);
            textview_4.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            textview_4.setText(updatifyContent2);
            textview_4.setTextSize(14);
            textview_4.setTypeface(textview_4.getTypeface(), Typeface.BOLD);
            textview_4.setTextColor(Color.parseColor(UpdatifyTxtColor));
            linear_55.addView(textview_4);
            //DIALOG IMAGE

            final ImageView img1 = new ImageView(context);
            img1.setLayoutParams(new LinearLayout.LayoutParams(90,90, 0.0f));
            img1.setPadding(0,0,0,0);
            if (UpdatifyMap.get("dialogOption").toString().equals("custom")) {
                Glide.with(context).load(Uri.parse((UpdatifyMap.get("customDialogIcon").toString()))).into(img1);
            } else {
                if (UpdatifyMap.get("dialogOption").toString().equals("message")) {
                    Glide.with(context).load(Uri.parse("https://nerbly.com/updatify/media/dialog/dia_msg.png")).into(img1);
                }
                else {
                    if (UpdatifyMap.get("dialogOption").toString().equals("warning")) {
                        Glide.with(context).load(Uri.parse("https://nerbly.com/updatify/media/dialog/dia_warning.png")).into(img1);
                    }
                    else {
                        Glide.with(context).load(Uri.parse("https://nerbly.com/updatify/media/dialog/dia_update.png")).into(img1);
                    }
                }
                img1.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF")}));
            }

            linear_1.addView(img1);
            linear_1.setElevation((float)5);
            linear_1.setTranslationY((float)(30));
            if (UpdatifyMap.get("dialogBtnExtra").toString().equals("true")) {
                //EXTRA BUTTON BACKGROUND

                final LinearLayout linear_5 = new LinearLayout(context);
                linear_5.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,50, 0.0f));
                linear_5.setPadding(8,8,8,8);
                linear_5.setOrientation(LinearLayout.HORIZONTAL);
                linear_55.addView(linear_5);
                //EXTRA BUTTON TEXTVIEW

                final TextView textview_5 = new TextView(context);
                textview_5.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,100, 01.0f));
                textview_5.setPadding(16,8,16,8);
                textview_5.setText(updatifyContent3);
                textview_5.setTextSize(14);
                textview_5.setTextColor(Color.parseColor(UpdatifyTxtColor));
                textview_5.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                linear_55.addView(textview_5);

                android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
                GG.setColor(Color.parseColor(UpdatifyColorBack));
                GG.setCornerRadius((float)UpdatifyRound);
                GG.setStroke((int) 0,
                        Color.parseColor(UpdatifyColor));
                android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#EEEEEE")}), GG, null);
                textview_5.setBackground(RE);
                textview_5.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (UpdatifyMap.get("dialogBtnExtraClick").toString().equals("exit")) {
                            ((Activity)context).finishAffinity();
                        }
                        else {
                            if (UpdatifyMap.get("dialogBtnExtraClick").toString().equals("browser")) {
                                if (UpdatifyMap.get("isCancelable").toString().equals("true")) {
                                    try {
                                        Intent UpdatifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UpdatifyMap.get("openLinkExtra").toString()));
                                        context.startActivity(UpdatifyIntent);
                                    } catch(Exception e) {
                                        Muh_message(e.toString(),context);
                                    }
                                }
                                else {
                                    if (UpdatifyMap.get("isCancelable").toString().equals("false")) {
                                        try {
                                            Intent UpdatifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UpdatifyMap.get("openLinkExtra").toString()));
                                            context.startActivity(UpdatifyIntent);
                                            ((Activity)context).finishAffinity();
                                        } catch(Exception e) {
                                            Muh_message(e.toString(),context);
                                        }
                                    }
                                    else {
                                        Muh_message("Updatify error [CANCEL]",context);
                                    }
                                }
                            }
                            else {
                                if (UpdatifyMap.get("dialogBtnExtraClick").toString().equals("dismiss")) {
                                    if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {
                                        updatifySheet.dismiss();
                                    } else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {
                                        updatifyDialog.dismiss();
                                    }
                                }
                                else {
                                    Muh_message("Updatify error [DISMISS]",context);
                                }
                            }
                        }
                    }
                });
            }


            if (UpdatifyMap.get("dialogBtnMain").toString().equals("true")) {
                //MAIN BUTTON BACKGROUND

                final LinearLayout linear_512 = new LinearLayout(context);
                linear_512.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,30, 0.0f));
                linear_512.setPadding(8,8,8,8);
                linear_512.setOrientation(LinearLayout.HORIZONTAL);
                linear_55.addView(linear_512);
                //MAIN BUTTON BACKGROUND

                final TextView textview_6 = new TextView(context);
                textview_6.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,100, 0.0f));
                textview_6.setPadding(16,8,16,8);
                textview_6.setText(updatifyContent4);
                textview_6.setTextSize(14);
                textview_6.setTextColor(Color.parseColor(UpdatifyBtnTxtColor));
                textview_6.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                linear_55.addView(textview_6);

                android.graphics.drawable.GradientDrawable GG1 = new android.graphics.drawable.GradientDrawable();
                GG1.setColor(Color.parseColor(UpdatifyColor));
                GG1.setCornerRadius((float)UpdatifyRound);
                GG1.setStroke((int) 0,
                        Color.parseColor(UpdatifyColor));
                android.graphics.drawable.RippleDrawable RE1 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#EEEEEE")}), GG1, null);
                textview_6.setBackground(RE1);
                textview_6.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (UpdatifyMap.get("dialogBtnMainClick").toString().equals("exit")) {
                            ((Activity)context).finishAffinity();
                        }
                        else {
                            if (UpdatifyMap.get("dialogBtnMainClick").toString().equals("browser")) {
                                if (UpdatifyMap.get("isCancelable").toString().equals("true")) {
                                    try {
                                        Intent UpdatifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UpdatifyMap.get("openLinkMain").toString()));
                                        context.startActivity(UpdatifyIntent);
                                        ((Activity)context).finishAffinity();
                                    } catch(Exception e) {
                                        Muh_message(e.toString(),context);

                                    }
                                }
                                else {
                                    if (UpdatifyMap.get("isCancelable").toString().equals("false")) {
                                        try {
                                            Intent UpdatifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UpdatifyMap.get("openLinkMain").toString()));
                                            context.startActivity(UpdatifyIntent);
                                        } catch(Exception e) {
                                            Muh_message(e.toString(),context);
                                        }
                                    }
                                    else {
                                        Muh_message("Updatify error [CANCEL]",context);
                                    }
                                }
                            }
                            else {
                                if (UpdatifyMap.get("dialogBtnMainClick").toString().equals("dismiss")) {
                                    if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {

                                        updatifySheet.dismiss();

                                    } else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {

                                        updatifyDialog.dismiss();

                                    }
                                }
                                else {
                                    Muh_message("Updatify error [DISMISS]",context);
                                }
                            }
                        }
                    }
                });
            }


            if (UpdatifyMap.get("isCancelable").toString().equals("false")) {
                if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {

                    updatifySheet.setCancelable(false);

                } else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {

                    updatifyDialog.setCancelable(false);

                }
            }
            else {
                if (UpdatifyMap.get("isCancelable").toString().equals("true")) {
                    if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {

                        updatifySheet.setCancelable(true);

                    } else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {

                        updatifyDialog.setCancelable(true);

                    }
                }
                else {
                    Muh_message("Updatify error [CANCEL]",context);
                }
            }

            if (UpdatifyMap.get("newVersion").toString().equals(UpdatifyCurrVer)) {

            }
            else {
                if (UpdatifyMap.get("isOneTime").toString().equals("true")) {
                    if ((UCSP.getString("isOneTime", "").equals(UpdatifyMap.get("isOneTimeKey").toString()))) {

                    }
                    else {
                        UCSP.edit().putString("isOneTime", UpdatifyMap.get("isOneTimeKey").toString()).commit();

                        if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {

                            updatifySheet.show();

                        } else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {

                            updatifyDialog.show();

                        }

                    }
                }
                else {
                    if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {

                        updatifySheet.show();

                    } else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {

                        updatifyDialog.show();

                    }
                }
            }

        }catch(Exception e){

        }
    }
    private void Muh_message(String msg,Context context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
