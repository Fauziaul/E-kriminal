package org.d3if0097.pt2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import org.d3if0097.pt2.databinding.ActivityMainBinding
import org.d3if0097.pt2.model.ResponseLogin
import org.d3if0097.pt2.network.RetrofitClient
import org.d3if0097.pt2.ui.home.HomeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var binding :ActivityMainBinding? = null
    private var email : String = " "
    private var password : String = " "
    //    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.btnLogin.setOnClickListener {
            email= binding!!.txtEmailInput.text.toString()
            password = binding!!.txtPswInput.text.toString()

            when {
                email == "" -> {
                    binding!!.txtEmailInput.error = "Username Tidak Boleh Kosong"
                }
                password == "" -> {
                    binding!!.txtPswInput.error = "Password Tidak Boleh Kosong"
                }
                else ->{
                    binding!!.loading.visibility = View.VISIBLE
                    getData()
                }
            }
        }


    }



    private fun getData () {
        val api = RetrofitClient().getInstace()
        api.login(email, password).enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if (response.isSuccessful) {
                    if (response.body()?.response == true) {
                        binding!!.loading.visibility = View.GONE
                        startActivity(Intent(this@MainActivity, BerandaActivity::class.java))
                    } else {
                        binding!!.loading.visibility = View.GONE
                        Toast.makeText(
                            this@MainActivity,
                            "login gagal, periksa kembali username dan password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.d("error", "${t.message}")
            }

        })
    }
}