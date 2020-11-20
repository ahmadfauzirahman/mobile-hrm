package ci.ahmadfauzirahman.hrm;


import android.location.Location;

public class Testing {

    /*
    Formula Haversine
    a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
    c = 2 ⋅ atan2( √a, √(1−a) )
    d = R ⋅ c

    φ adalah latitude, λ adalah longitude, R is radius bumi (radius = 6,371km);
    “perlu dicatat, bahwa sudut harus dalam radian agar bisa berjalan di fungsi trigonometri!”
    */


    public static void main(String[] args) {
        double hasil = Testing.getJarak(0.4692034, 101.3892762, 0.5233203, 101.451869);
        String h = "Kurang Dari 1 KM";
        if (hasil < 1.0) {
            System.out.println("Jarak RSUD DARI LOKASI SAYA SEKARANG " + h);
        } else {
            System.out.println("Jarak RSUD DARI LOKASI SAYA SEKARANG " + hasil + " Km");
        }
    }

    public static double getJarak(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 3958.75;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        int meterConversion = 1609;
        double myjr = dist * meterConversion;
        return Math.floor(myjr / 1000);

    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }

}
