package io.github.aerhakim.pilihdompet.activity;

//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.database.Cursor;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//import io.github.aerhakim.pilihdompet.Config;
//import io.github.aerhakim.pilihdompet.R;
//import io.github.aerhakim.pilihdompet.model.PostPutDelHeros;
//import io.github.aerhakim.pilihdompet.rest.ApiClient;
//import io.github.aerhakim.pilihdompet.rest.ApiInterface;
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class EditActivity extends AppCompatActivity {
//
//    EditText edtName, edtDescription, edtKode, edtHarga, edtStok, edtProdusen;
//    ImageView imgHolder;
//    String ID;
//    Button btnGalery, btUpdate;
//
//    private String mediaPath;
//    private String postPath;
//
//    ApiInterface mApiInterface;
//    private static final int REQUEST_PICK_PHOTO = Config.REQUEST_PICK_PHOTO;
//    private static final int REQUEST_WRITE_PERMISSION = Config.REQUEST_WRITE_PERMISSION;
//
//    private final int ALERT_DIALOG_CLOSE = Config.ALERT_DIALOG_CLOSE;
//    private final int ALERT_DIALOG_DELETE = Config.ALERT_DIALOG_DELETE;
//    private static final String UPDATE_FLAG = Config.UPDATE_FLAG;
//
//    // Akses Izin Ambil Gambar dari Storage
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == REQUEST_WRITE_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            updateImageUpload();
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit);
//
//        // Identifikasi Komponen Action Bar
//        String actionBarTitle;
//        actionBarTitle = "Ubah";
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
//        btUpdate = (Button) findViewById(R.id.btn_submit);
//
//        // Identifikasi intent ke Komponen Form
//        Intent mIntent = getIntent();
//        ID = mIntent.getStringExtra("Id");
//        edtName.setText(mIntent.getStringExtra("Name"));
//        edtDescription.setText(mIntent.getStringExtra("Description"));
//        edtKode.setText(mIntent.getStringExtra("Kode"));
//        edtHarga.setText(mIntent.getStringExtra("Harga"));
//        edtStok.setText(mIntent.getStringExtra("Stok"));
//        edtProdusen.setText(mIntent.getStringExtra("Produsen"));
//
//
//        // Masukan Gambar Ke Image View Gunakan Glide
//        Glide.with(EditActivity.this)
//                .load(Config.IMAGES_URL + mIntent.getStringExtra("Image"))
//                .apply(new RequestOptions().override(350, 550))
//                .into(imgHolder);
//
//        // Definisi API
//        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
//
//        // Fungsi Tombol Pilih Galery
//        btnGalery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(galleryIntent, REQUEST_PICK_PHOTO);
//            }
//        });
//
//        // Fungsi Tombol Update
//        btUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                updateImageUpload();
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
//    // Update Gambar
//    private void updateImageUpload() {
//        final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
//        if (mediaPath== null)
//        {
//            Toast.makeText(getApplicationContext(), "Pilih gambar dulu, baru update ...!", Toast.LENGTH_LONG).show();
//        }
//        else {
//            File imagefile = new File(mediaPath);
//            RequestBody reqBody = RequestBody.create(MediaType.parse("multipart/form-file"), imagefile);
//            MultipartBody.Part partImage = MultipartBody.Part.createFormData("image", imagefile.getName(), reqBody);
//
//            Call<PostPutDelHeros> putHerosCall = mApiInterface.postUpdateHeros(partImage, RequestBody.create(MediaType.parse("text/plain"), ID), RequestBody.create(MediaType.parse("text/plain"),
//                    edtName.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtDescription.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtKode.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtHarga.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtStok.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    edtProdusen.getText().toString()), RequestBody.create(MediaType.parse("text/plain"),
//                    date), RequestBody.create(MediaType.parse("text/plain"), UPDATE_FLAG));
//            putHerosCall.enqueue(new Callback<PostPutDelHeros>() {
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
//            updateImageUpload();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_form, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_delete:
//                showAlertDialog(ALERT_DIALOG_DELETE);
//                break;
//            case android.R.id.home:
//                showAlertDialog(ALERT_DIALOG_CLOSE);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onBackPressed() {
//        showAlertDialog(ALERT_DIALOG_CLOSE);
//    }
//
//    private void showAlertDialog(int type) {
//        final boolean isDialogClose = type == ALERT_DIALOG_CLOSE;
//        String dialogTitle, dialogMessage;
//
//        if (isDialogClose) {
//            dialogTitle = "Batal";
//            dialogMessage = "Apakah anda ingin membatalkan perubahan pada form?";
//        } else {
//            dialogMessage = "Apakah anda yakin ingin menghapus item ini?";
//            dialogTitle = "Hapus Heros";
//        }
//
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        alertDialogBuilder.setTitle(dialogTitle);
//        alertDialogBuilder
//                .setMessage(dialogMessage)
//                .setCancelable(false)
//                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        if (isDialogClose) {
//                            finish();
//                        } else {
//                            // Kode Hapus
//                            if (ID.trim().isEmpty()==false){
//                                Call<PostPutDelHeros> deleteHeros = mApiInterface.deleteHeros(ID);
//                                deleteHeros.enqueue(new Callback<PostPutDelHeros>() {
//                                    @Override
//                                    public void onResponse(Call<PostPutDelHeros> call, Response<PostPutDelHeros> response) {
//                                        ObatActivity.ma.refresh();
//                                        finish();
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<PostPutDelHeros> call, Throwable t) {
//                                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                                    }
//                                });
//                            }else{
//                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                            }
//                        }
//                    }
//                })
//                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }
}