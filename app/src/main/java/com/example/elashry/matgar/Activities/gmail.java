package com.example.elashry.matgar.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.elashry.matgar.Fragments.Login_Fragment;
import com.example.elashry.matgar.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class gmail extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "ProfileActivity";
    private GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail);
        mGoogleApiClient = ((MyApplication) getApplication()).getGoogleApiClient(gmail.this, this);
        CircleImageView profilePhoto = (CircleImageView)findViewById(R.id.profile_image);
        TextView profileUsername = (TextView)findViewById(R.id.profile_name);
        TextView profileEmail = (TextView)findViewById(R.id.profile_email);
        String profileDisplayName = returnValueFromBundles(Login_Fragment.PROFILE_DISPLAY_NAME);
        String profileUserEmail = returnValueFromBundles(Login_Fragment.PROFILE_USER_EMAIL);
        String profileImageLink = returnValueFromBundles(Login_Fragment.PROFILE_IMAGE_URL);
        Picasso.with(gmail.this).load(profileImageLink).into(profilePhoto);
        assert profileUsername != null;
        profileUsername.setText(profileDisplayName);
        assert profileEmail != null;
        profileEmail.setText(profileUserEmail);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                    new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status status) {
                            Intent login = new Intent(gmail.this, Login.class);
                            startActivity(login);
                            finish();
                        }
                    });
            return true;
        }
        if(id == R.id.action_disconnect){
            Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                    new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status status) {
                            Intent login = new Intent(gmail.this, Login.class);
                            startActivity(login);
                            finish();
                        }
                    });
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private String returnValueFromBundles(String key){
        Bundle inBundle = getIntent().getExtras();
        String returnedValue = inBundle.get(key).toString();
        return returnedValue;
    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }
    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }
    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }
}