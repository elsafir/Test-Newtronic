package com.example.testnewtronic;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewpagerAdapter extends FragmentStateAdapter {

    public ViewpagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Membuat dan mengembalikan fragment sesuai dengan posisi
        // Di sini Anda bisa membuat fragment baru atau menggunakan fragment yang sudah ada
        return new Fragment1(); // Gantikan MyFragment dengan kelas fragment Anda
    }

    @Override
    public int getItemCount() {
        // Mengembalikan jumlah total halaman (fragment) yang ingin ditampilkan
        return 5; // Ganti dengan jumlah total halaman yang Anda inginkan
    }
}

