package com.example.shepur.myapplication;

public class MappingHelper {

    public static int getMediaIdOfButton(int buttonResourceId){
        int mediaId = 0;
        switch (buttonResourceId) {
            case R.id.saButton:
            case R.id.saAnsButton:
                mediaId = R.raw.sa;
                break;
            case R.id.reKomalButton:
            case R.id.reKomalAnsButton:
                mediaId = R.raw.re_komal;
                break;
            case R.id.reButton:
            case R.id.reAnsButton:
                mediaId = R.raw.re;
                break;
            case R.id.gaKomalButton:
            case R.id.gaKomalAnsButton:
                mediaId = R.raw.ga_komal;
                break;
            case R.id.gaButton:
            case R.id.gaAnsButton:
                mediaId = R.raw.ga;
                break;
            case R.id.maButton:
            case R.id.maAnsButton:
                mediaId = R.raw.ma;
                break;
            case R.id.maTivarButton:
            case R.id.maTivraAnsButton:
                mediaId = R.raw.ma_tivra;
                break;
            case R.id.paButton:
            case R.id.paAnsButton:
                mediaId = R.raw.pa;
                break;
            case R.id.dhaKomalButton:
            case R.id.dhaKomalAnsButton:
                mediaId = R.raw.dha_komal;
                break;
            case R.id.dhaButton:
            case R.id.dhaAnsButton:
                mediaId = R.raw.dha;
                break;
            case R.id.niKomalButton:
            case R.id.niKomalAnsButton:
                mediaId = R.raw.ni_komal;
                break;
            case R.id.niButton:
            case R.id.niAnsButton:
                mediaId = R.raw.ni;
                break;
            case R.id.ssButton:
            case R.id.ssAnsButton:
                mediaId = R.raw.ss;
                break;
        }
        return mediaId;
    }
}
