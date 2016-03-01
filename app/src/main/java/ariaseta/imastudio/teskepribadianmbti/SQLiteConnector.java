package ariaseta.imastudio.teskepribadianmbti;

/**
 * Created by ariasetasetiaalam on 12/18/15.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteConnector extends SQLiteOpenHelper {
    private static final String nama_database = "database_pemain.db";
    private static final int versi_database = 1;
    private static final String query_buat_tabel_biodata_pemain = "CREATE TABLE IF NOT EXISTS tabel_biodata(id_biodata INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT,alamat TEXT)";
    private static final String query_hapus_tabel_biodata_pemain = "DROP TABLE IF EXISTS query_buat_tabel_biodata_pemain";

    public SQLiteConnector(Context context) {
        super(context, nama_database, null, versi_database);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query_buat_tabel_biodata_pemain);
        System.out.println("tabel_biodata sudah dibuat");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int versi_lama, int versi_baru) {
        database.execSQL(query_hapus_tabel_biodata_pemain);
        onCreate(database);

    }

    public void tambah_biodata(String nama, String alamat) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", nama);
        values.put("alamat", alamat);
        database.insert("tabel_biodata", null, values);
        database.close();
    }



}

