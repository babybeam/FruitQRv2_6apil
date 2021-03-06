package kiky.beam.lilly.th.ac.rmutk.fruitqr;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuDrawerFragment extends Fragment {

    //    Admin
    private int[] iconAdmin = {
            R.drawable.ic_action_home,
            R.drawable.ic_action_qrb,
            R.drawable.ic_action_framer,
            R.drawable.ic_action_listframer,
            R.drawable.ic_action_product,
            R.drawable.ic_action_listproduct,
            R.drawable.ic_action_register,
            R.drawable.ic_action_aboutme,
            R.drawable.ic_action_aboutme,
            R.drawable.ic_action_exit
    };
    private String[] titleAdmin = {
            "หน้าหลัก1",
            "สแกน QR Code",
            "รายการผลผลิต",
            "เพิ่มรายการผลผลิต",
            "รายการผลิตภัณฑ์",
            "เพิ่มรายการผลิตภัณฑ์",
            "เพิ่มสมาชิก",
            "ข้อมูลส่วนตัว",
            "เกี่ยวกับเรา",
            "ออกจากระบบ"
    };

    //    Framer
    private int[] iconFramer = {
            R.drawable.ic_action_home,
            R.drawable.ic_action_qrb,
            R.drawable.ic_action_framer,
            R.drawable.ic_action_listframer,
            R.drawable.ic_action_aboutme,
            R.drawable.ic_action_aboutme,
            R.drawable.ic_action_exit
    };

    private String[] titleFramer = {
            "หน้าหลัก2",
            "สแกน QR Code",
            "รายการผลผลิต",
            "เพิ่มรายการผลผลิต",
            "ข้อมูลส่วนตัว",
            "เกี่ยวกับเรา",
            "ออกจากระบบ"
    };

    //    Product
    private int[] iconProduce = {
            R.drawable.ic_action_home,
            R.drawable.ic_action_qrb,
            R.drawable.ic_action_product,
            R.drawable.ic_action_listproduct,
            R.drawable.ic_action_aboutme,
            R.drawable.ic_action_aboutme,
            R.drawable.ic_action_exit
    };
    private String[] titleProduct = {
            "หน้าหลัก3",
            "สแกน QR Code",
            "รายการผลิตภัณฑ์",
            "เพิ่มรายการผลิตภัณฑ์",
            "ข้อมูลส่วนตัว",
            "เกี่ยวกับเรา",
            "ออกจากระบบ"};

    //    Customer
    private int[] iconCustomer = {
            R.drawable.ic_action_home,
            R.drawable.ic_action_qrb,
            R.drawable.ic_action_framer,
            R.drawable.ic_action_listframer,
            R.drawable.ic_action_product,
            R.drawable.ic_action_listproduct,
            R.drawable.ic_action_aboutme,
            R.drawable.ic_action_aboutme,
            R.drawable.ic_action_exit
    };
    private String[] titleCustomer = {
            "หน้าหลัก4",
            "สแกน QR Code",
            "รายการผลผลิต",
            "เพิ่มรายการผลผลิต",
            "รายการผลิตภัณฑ์",
            "เพิ่มรายการผลิตภัณฑ์",
            "ข้อมูลส่วนตัว",
            "เกี่ยวกับเรา",
            "ออกจากระบบ"
    };


    public MenuDrawerFragment() {
        // Required empty public constructor
    }

    public static MenuDrawerFragment menuDrawerInstance(String typeDataString) {
        MenuDrawerFragment menuDrawerFragment = new MenuDrawerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TypeData", typeDataString);
        menuDrawerFragment.setArguments(bundle);
        return menuDrawerFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String typeDataString = getArguments().getString("TypeData").trim();
        int typeDataInt = Integer.parseInt(typeDataString);

        switch (typeDataInt) {
            case 1:
                showMenu(iconAdmin, titleAdmin);
                break;
            case 2:
                showMenu(iconFramer, titleFramer);
                break;
            case 3:
                showMenu(iconProduce, titleProduct);
                break;
            case 4:
                showMenu(iconCustomer, titleCustomer);
                break;
        }


    }

    private void showMenu(int[] iconInts, String[] titleStrings) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i = 0; i < titleStrings.length; i += 1) {
            integerArrayList.add(iconInts[i]);
            stringArrayList.add(titleStrings[i]);
        }

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerDrawerMenu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        MenuDrawerAdapter menuDrawerAdapter = new MenuDrawerAdapter(getActivity(), integerArrayList, stringArrayList, new OnClickItem() {
            @Override
            public void onClickitem(View view, int position) {

            }
        });
        recyclerView.setAdapter(menuDrawerAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_drawer, container, false);
    }

}