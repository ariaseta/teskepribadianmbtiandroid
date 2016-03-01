package ariaseta.imastudio.teskepribadianmbti;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ariasetasetiaalam on 12/18/15.
 */
public class HalamanTes extends Activity {


    int nomer_soal=1;

    //Intent i;
    String kodeKiriman;

    Button btnSoalA;
    Button btnSoalB;
    TextView soalA;
    TextView soalB;
    TextView judul;
    TextView debugger;

    String isiSoalA[];
    String isiSoalB[];
    //String tipeSoal[];
    String tipeSoalIntrovert[];
    String tipeSoalSensing[];
    String tipeSoalThingking[];
    String tipeSoalJudging[];
    String tipeSoalEkstrovert[];
    String tipeSoalIntuition[];
    String tipeSoalFeeling[];
    String tipeSoalPerceiving[];
    int introvert, sensing, thinking, judging, ekstrovert, intuition, feeling, perceiving;

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_tes);


//        //Init UI
        soalA = (TextView) findViewById(R.id.soalA);
        soalB = (TextView) findViewById(R.id.soalB);
        judul = (TextView) findViewById(R.id.judul);
        debugger = (TextView) findViewById(R.id.debugger);
        btnSoalA = (Button) findViewById(R.id.buttonA);
        btnSoalB = (Button) findViewById(R.id.buttonB);
        bikinDialog();

        //Init Isi Awal
        initSoal();
        nomer_soal =1;
        soalA.setText(isiSoalA[nomer_soal-1]);
        soalB.setText(isiSoalB[nomer_soal-1]);
        judul.setText("Soal No "+nomer_soal+" ("+nomer_soal+"/60)");


        btnSoalA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String kode = "A"+nomer_soal;
                cekJawaban(kode);

                if(nomer_soal==60){

                    initKirim();

                } else{
                    nomer_soal++;
                    updateView();
                }


            }
        });

        btnSoalB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String kode = "B"+nomer_soal;
                cekJawaban(kode);

                if(nomer_soal==60){

                    initKirim();

                } else{
                    nomer_soal++;
                    updateView();
                }

            }
        });

    }

    public void bikinDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah anda ingin keluar dari tes?");

        alertDialogBuilder.setNegativeButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }

        });

        alertDialogBuilder.setPositiveButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(getApplicationContext(), "You clicked yes button", Toast.LENGTH_LONG).show();
            }

        });

        alertDialog = alertDialogBuilder.create();

    }

    @Override
    public void onBackPressed() {
        alertDialog.show();

    }


    public void cekJawaban(String kode){

        //Ngecek Introvert
        if(cariString(kode,tipeSoalIntrovert)){
            introvert++;
        } else

            //Ngecek Ekstrovert
            if(cariString(kode,tipeSoalEkstrovert)){
                ekstrovert++;
            } else

                //Ngecek Sensing
                if(cariString(kode,tipeSoalSensing)){
                    sensing++;
                } else

                    //Ngecek Thinking
                    if(cariString(kode,tipeSoalThingking)){
                        thinking++;
                    } else

                        //Ngecek Judging
                        if(cariString(kode,tipeSoalJudging)){
                            judging++;
                        } else

                            //Ngecek Intuition
                            if(cariString(kode,tipeSoalIntuition)){
                                intuition++;
                            } else

                                //Ngecek Feeling
                                if(cariString(kode,tipeSoalFeeling)){
                                    feeling++;
                                } else

                                    //Ngecek Perceiving
                                    if(cariString(kode,tipeSoalPerceiving)){
                                        perceiving++;
                                    }

    }

    public void initSoal(){
        isiSoalA = new String[] { "Spontan, Fleksibel, tidak diikat waktu" , "Lebih memilih berkomunikasi dengan menulis" , "Tidak menyukai hal-hal yang bersifat mendadak dan di luar perencanaan", "Obyektif", "Menemukan dan mengembangkan ide dengan mendiskusikannya", "Bergerak dari gambaran umum baru ke detail", "Berorientasi pada dunia eksternal (kegiatan, orang)", "Berbicara mengenai masalah yang dihadapi hari ini dan langkah-langkah praktis mengatasinya", "Diyakinkan dengan penjelasan yang menyentuh perasaan", "Fokus pada sedikit hobi namun mendalam",
                "Tertutup dan mandiri", "Aturan, jadwal dan target sangat mengikat dan membebani","Menggunakan pengalaman sebagai pedoman","Berorientasi tugas dan job description","Pertemuan dengan orang lain dan aktivitas sosial melelahkan","SOP sangat membantu","Mengambil keputusan berdasar logika dan aturan main","Bebas dan dinamis","Berorientasi pada hasil","Beraktifitas sendirian di rumah menyenangkan",
                "Membiarkan orang lain bertindak bebas asalkan tujuan tercapai","Memilih ide inspiratif lebih penting daripada fakta","Mengemukakan tujuan dan sasaran lebih dahulu","Fokus pada target dan mengabaikan hal-hal baru","Kontinuitas dan stabilitas lebih diutamakan","Pendirian masih bisa berubah tergantung situasi nantinya","Bertindak step by step dengan timeframe yang jelas","Berinisiatif tinggi hampir dalam berbagai hal meskipun tidak berhubungan dengan dirinya","Lebih memilih tempat yang tenang dan pribadi untuk berkonsentrasi","Menganalisa",
                "Berpikir secara matang sebelum bertindak","Menghargai seseorang karena sifat dan perilakunya","Merasa nyaman bila situasi tetap terbuka terhadap pilihan-pilihan lain","Menarik kesimpulan dengan lama dan hati-hati","Mengekspresikan semangat","Mengklarifikasi ide dan teori sebelum dipraktekkan","Melibatkan perasaan itu tidak profesional","Mencari kesempatan untuk berkomunikasi secara perorangan","Yang penting situasi harmonis terjaga","Ketidakpastian itu seru, menegangkan dan membuat hati lebih senang",
                "Berfokus pada masa kini (apa yang bisa diperbaiki sekarang)","Mempertanyakan","Secara konsisten mengamati dan mengingat detail","Situasi last minute membuat bersemangat dan memunculkan potensi","Lebih suka komunikasi tidak langsung (telp, surat, e-mail)","Praktis","Perubahan adalah musuh","Sering dianggap keras kepala","Bersemangat saat menolong orang keluar dari kesalahan dan meluruskan","Bertindak sesuai situasi dan kondisi yang terjadi saat itu",
                "Menggunakan keterampilan yang sudah dikuasai","Membangun ide pada saat berbicara","Memilih cara yang sudah ada dan sudah terbukti","Hidup harus sudah diatur dari awal","Standar harus ditegakkan di atas segalanya (itu menunjukkan kehormatan dan harga diri)","Daftar dan checklist adalah panduan penting","Menuntut perlakuan yang adil dan sama pada semua orang","Mementingkan sebab-akibat","Puas ketika mampu beradaptasi dengan momentum yang terjadi","Spontan, Easy Going, fleksibel",};

        isiSoalB = new String[] { "Terencana dan memiliki deadline jelas" , "Lebih memilih berkomunikasi dengan bicara" , "Perubahan mendadak tidak jadi masalah", "Subyektif", "Menemukan dan mengembangkan ide dengan merenungkan", "Bergerak dari detail ke gambaran umum sebagai kesimpulan akhir", "Berorientasi pada dunia internal (memori, pemikiran, ide)", "Berbicara mengenai visi masa depan dan konsep-konsep mengenai visi tersebut", "Diyakinkan dengan penjelasan yang masuk akal", "Fokus pada banyak hobi secara luas dan umum",
                "Sosial dan ekspresif", "Aturan, jadwal dan target akan sangat membantu dan memperjelas tindakan","Menggunakan imajinasi dan perenungan sebagai pedoman","Berorientasi pada manusia dan hubungan","Bertemu orang dan aktivitas sosial membuat bersemangat","SOP sangat membosankan","Mengambil keputusan berdasar perasaan pribadi dan kondisi orang lain","Prosedural dan tradisional","Berorientasi pada proses","Beraktifitas sendirian di rumah membosankan",
                "Mengatur orang lain dengan tata tertib agar tujuan tercapai","Memilih fakta lebih penting daripada ide inspiratif","Mengemukakan kesepakatan terlebih dahulu","Memperhatikan hal-hal baru dan siap menyesuaikan diri serta mengubah target","Perubahan dan variasi lebih diutamakan","Berpegang teguh pada pendirian","Bertindak dengan semangat tanpa menggunakan timeframe","Berinisiatif bila situasi memaksa atau berhubungan dengan kepentingan sendiri","Lebih memilih tempat yang ramai dan banyak interaksi / aktifitas","Berempati",
                "Berani bertindak tanpa terlalu lama berfikir","Menghargai seseorang karena skill dan faktor teknis","Merasa tenang bila semua sudah diputuskan","menarik kesimpulan dengan cepat sesuai naluri","Menyimpan semangat dalam hati","Memahami ide dan teori saat mempraktekkannya langsung","Terlalu kaku pada peraturan dan pekerjaan itu kejam","Memilih berkomunikasi pada sekelompok orang","Yang penting tujuan tercapai","Ketidakpastian membuat bingung dan meresahkan",
                "Berfokus pada masa depan (apa yang mungkin dicapai di masa depan)","Mengakomodasi","Mengamati dan mengingat detail hanya bila berhubungan dengan pola","Situasi last minute sangat menyiksa, membuat stress dan merupakan kesalahan","Lebih suka komunikasi langsung (tatap muka)","Konseptual","Perubahan adalah semangat hidup","Sering dianggap terlalu memihak","Bersemangat saat mengkritik dan menemukan kesalahan","Bertindak sesuai apa yang sudah direncanakan",
                "Menyukai tantangan untuk menguasai keterampilan baru","Membangun ide dengan matang baru membicarakannya","Memilih cara yang unik dan belum dipraktekkan orang lain","Hidup seharusnya mengalir sesuai kondisi","Perasaan manusia lebih penting dari sekadar standar (yang adalah benda mati)","Daftar dan checklist adalah tugas dan beban","Menuntut perlakuan khusus sesuai karakteristik masing-masing orang","Mementingkan nilai-nilai personal","Puas ketika mampu menjalankan semuanya sesuai rencana","Berhati-hati, penuh pertimbangan, kaku",};

        tipeSoalIntrovert = new String[] {"B60","B52","A45","A38","B35","A31","A29","B28","A20","A15","A11","A10","B7","B5","A2"};
        tipeSoalEkstrovert = new String[] {"A60","A52","B45","B38","A35","B31","B29","A28","B20","B15","B11","B10","A7","A5","B2"};
        tipeSoalSensing = new String[] {"A53","A51","A46","A43","A41","A36","A34","A27","A25","B22","B18","A16","A13","A8","B6"};
        tipeSoalIntuition = new String[] {"B53","B51","B46","B43","B41","B36","B34","B27","B25","A22","A18","B16","B13","B8","A6"};
        tipeSoalThingking = new String[] {"A58","A57","A55","B49","A48","A42","B39","A37","A23","B32","A30","A17","B9","A4","A14"};
        tipeSoalFeeling = new String[] {"B58","B57","B55","A49","B48","B42","A39","B37","A32","B30","B23","B17","B14","A9","B4"};
        tipeSoalJudging = new String[] {"B59","A56","A54","B50","A47","B44","B40","B33","B26","A24","B21","A19","B12","A3","B1"};
        tipeSoalPerceiving = new String[] {"A59","B56","B54","A50","B47","A44","A40","A33","A26","B24","A21","B19","A12","B3","A1"};
    }

    public boolean cariString(String kode, String[] tipeSoal){
        int banyakPencarian = tipeSoal.length;
        boolean dapetKode=false;

        for (int i=0;i<banyakPencarian;i++){
            if (kode.equals(tipeSoal[i])){
                dapetKode = true;
                break;
            }
        }

        return dapetKode;
    }

    public void updateView(){
        final int total= introvert+ekstrovert+sensing+intuition+thinking+feeling+judging+perceiving;
        soalA.setText(isiSoalA[nomer_soal-1]);
        soalB.setText(isiSoalB[nomer_soal-1]);
        judul.setText("Soal No "+nomer_soal+" ("+nomer_soal+"/60)");
        debugger.setText("I="+introvert+" | E="+ekstrovert + "TOTAL="+total);
    }

    public void initKirim(){
        Intent i = new Intent(getApplicationContext(),HasilTes.class);

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt("introvert", introvert);
        editor.putInt("ekstrovert", ekstrovert);
        editor.putInt("sensing", sensing);
        editor.putInt("intuition", intuition);
        editor.putInt("thinking", thinking);
        editor.putInt("feeling", feeling);
        editor.putInt("judging", judging);
        editor.putInt("perceiving",perceiving);
        editor.commit();

        startActivity(i);


    }


}
