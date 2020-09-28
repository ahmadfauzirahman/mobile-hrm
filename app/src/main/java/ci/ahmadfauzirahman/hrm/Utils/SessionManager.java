package ci.ahmadfauzirahman.hrm.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

import ci.ahmadfauzirahman.hrm.Model.UserModel;

public class SessionManager {
    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor editor;

    private Context _context;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID_USER = "userid";
    public static final String ID_PEGAWAI = "id_pegawai";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String NAMA  = "nama";

    public static final String IS_GET_LOCATION = "isLogged";
    public static final String TANGGAL_PENDAFTARAN = "tanggal_pendaftaran";
    public static final String ROLE = "role";
    public static final String LAT = "lat";
    public static final String LANG = "lang";

    public static final String penToken = "penToken";


    public Context get_context() {
        return _context;
    }

    //constuctor
    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(UserModel user){
        editor.putBoolean(IS_LOGGED_IN,true);
        editor.putString(ID_USER,String.valueOf(user.getUserid()));
        editor.putString(USERNAME,user.getUsername());
        editor.putString(PASSWORD,user.getPassword());
        editor.putString(ROLE,user.getRole());
        editor.putString(ID_PEGAWAI,user.getIdPegawai().toString());
        editor.putString(NAMA,user.getNama());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ID_USER,sharedPreferences.getString(ID_USER,null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME,null));
        user.put(PASSWORD, sharedPreferences.getString(PASSWORD,null));
        user.put(ROLE, sharedPreferences.getString(ROLE,null));
        user.put(ID_PEGAWAI, sharedPreferences.getString(ID_PEGAWAI,null));
        user.put(NAMA, sharedPreferences.getString(NAMA,null));
        return user;
    }

    public void setLocation (String alamat,String lat,String lang){
        editor.putBoolean(IS_GET_LOCATION,true);
        editor.putString(LAT,lat);
        editor.putString(LANG,lang);
        editor.commit();
    }

    public HashMap<String,String> getLocation() {
        HashMap<String,String> location = new HashMap<>();
        location.put(LAT,sharedPreferences.getString(LAT,null));
        location.put(LANG,sharedPreferences.getString(LANG,null));
        return location;
    }

    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

    public void saveToken(String fcm) {
        editor.putString(penToken, fcm);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGGED_IN,false);
    }

    public boolean isGetLocation() {
        return sharedPreferences.getBoolean(IS_GET_LOCATION,false);
    }
}
