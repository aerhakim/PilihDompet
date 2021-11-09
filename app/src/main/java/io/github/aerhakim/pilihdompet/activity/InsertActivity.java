package io.github.aerhakim.pilihdompet.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import io.github.aerhakim.pilihdompet.Config;
import io.github.aerhakim.pilihdompet.R;
import io.github.aerhakim.pilihdompet.model.PostPutDelHeros;
import io.github.aerhakim.pilihdompet.rest.ApiClient;
import io.github.aerhakim.pilihdompet.rest.ApiInterface;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
//
//    EditText edtName, edtDescription, edtKode, edtHarga, edtStok, edtProdusen;
//    Button btnGalery, btSubmit;
//    ImageView imgHolder;
//
//    private String mediaPath;
//    private String postPath;
//
//    ApiInterface mApiInterface;
//    private static final int REQUEST_PICK_PHOTO = Config.REQUEST_PICK_PHOTO;
//    private static final int REQUEST_WRITE_PERMISSION = Config.REQUEST_WRITE_PERMISSION;
//    private static final String INSERT_FLAG = Config.INSERT_FLAG;
//
//    // Akses Izin Ambil Gambar dari Storage
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == REQUEST_WRITE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            saveImageUpload();
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_insert);
//
//        // Identifikasi Komponen Action Bar
//        String actionBarTitle;
//        actionBarTitle = "Tambah";
//        getSupportActionBar().setTitle(actionBarTitle);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        // Identifikasi Komponen Form
//        edtName = (EditText) findViewById(R.id.edt_name);
//        edtDescription = (EditText) findViewById(R.id.edt_description);
//        edtKode = (EditText) findViewById(R.id.edt_kode);
//        edtHarga = (EditText) findViewById(R.id.edt_harga);
//        edtStok = (EditText) findViewById(R.id.edt_stok);
//        edtProdusen = (EditText) findViewById(R.id.edt_produsen);
//        imgHolder = (ImageView) findViewById(R.id.imgHolder);
//        btnGalery = (Button) findViewById(R.id.btn_galery);
//        btSubmit = (Button) findViewById(R.id.btn_submit);
//
//        // Definisi API
//        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//        // Fungsi Tombol Pilih Galery
//        btnGalery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(galleryIntent, REQUEST_PICK_PHOTO);
//            }
//        });
//
//        // Fungsi Tombol Simpan
//        btSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                requestPermission();
//            }
//        });
//    }
//
//    // Akses Izin Ambil Gambar dari Storage
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_OK) {
//            if (requestCode == REQUEST_PICK_PHOTO) {
//                if (data != null) {
//                    // Ambil Image Dari Galeri dan Foto
//                    Uri selectedImage = data.getData();
//                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//                    assert cursor != null;
//                    cursor.moveToFirst();
//
//                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                    mediaPath = cursor.getString(columnIndex);
//                    imgHolder.setImageURI(data.getData());
//                    cursor.close();
//
//                    postPath = mediaPath;
//                }
//            }
//        }
//    }
//
//    // Simpan Gambar
//    private void saveImageUpload(){
//        final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
//        if (mediaPath== null)
//        {
//            Toast.makeText(getApplicationContext(), "Pilih gambar dulu, baru simpan ...!", Toast.LENGTH_LONG).show();
//        }
//        else {
//            File imagefile = new File(mediaPath);
//            RequestBody reqBody = RequestBody.create(MediaType.parse("multipart/form-file"), imagefile);
//            MultipartBody.Part partImage = MultipartBody.Part.createFormData("image", imagefile.getName(), reqBody);
//
//            Call<PostPutDelHeros> postHerosCall = mApiInterface.postHeros(partImage, RequestBody.create(MediaType.parse("text/plain"),
//                    edtName.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtDescription.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtKode.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtHarga.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtStok.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtProdusen.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    date), RequestBody.create(MediaType.parse("text/plain"), INSERT_FLAG));
//            postHerosCall.enqueue(new Callback<PostPutDelHeros>() {
//                @Override
//                public void onResponse(Call<PostPutDelHeros> call, Response<PostPutDelHeros> response) {
//                    ObatActivity.ma.refresh();
//                    finish();
//                }
//
//                @Override
//                public void onFailure(Call<PostPutDelHeros> call, Throwable t) {
//                    Log.d("RETRO", "ON FAILURE : " + t.getMessage());
//                    //Log.d("RETRO", "ON FAILURE : " + t.getCause());
//                    Toast.makeText(getApplicationContext(), "Error, image", Toast.LENGTH_LONG).show();
//                }
//            });
//        }
//    }
//
//    // Cek Versi Android Tuk Minta Izin
//    private void requestPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
//        } else {
//            saveImageUpload();
//        }
//    }
//
//    // Menu Kembali Ke Home
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                // API 5+ solution
//                onBackPressed();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}