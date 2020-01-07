package com.example.cobacrud;

public class Konfigurasi {

    // lokasi script CRUD php disimpan
    public static final String URL_ADD="http://172.23.3.10/Android/mahasiswa/tambahmhs.php";
    public static final String URL_GET_ALL="http://172.23.3.10/Android/mahasiswa/tampilallmhs.php";
    public static final String URL_GET_MHS="http://172.23.3.10/Android/mahasiswa/tampilmhs.php?id=";
    public static final String URL_UPDATE_MHS="http://172.23.3.10/Android/mahasiswa/updatemhs.php";
    public static final String URL_DELETE_MHS="http://172.23.3.10/Android/mahasiswa/hapusmhs.php?id=";

    // mengirim permintaan skrip ke php
    public static final String KEY_MHS_ID = "id";
    public static final String KEY_MHS_NAMA = "name";
    public static final String KEY_MHS_ALAMAT = "address";

    // JSON tags
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "name";
    public static final String TAG_ALAMAT = "address";

    public static final String MHS_ID = "id_mhs";
    //public static final String MHS_NAMA = "nama_mhs";

}
