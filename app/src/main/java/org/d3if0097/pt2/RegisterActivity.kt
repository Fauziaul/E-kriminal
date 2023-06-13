package org.d3if0097.pt2

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import org.d3if0097.pt2.databinding.FragmentRegisterBinding
import org.d3if0097.pt2.model.ResponseLogin
import org.d3if0097.pt2.model.ResponseRegister
import org.d3if0097.pt2.network.RetrofitClient
import org.d3if0097.pt2.ui.profile.ProfileFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private var binding: FragmentRegisterBinding ?= null
    private lateinit var auth: FirebaseAuth
    private var email: String = " "
    private var username: String = " "
    private var phone: String = " "
    private var password: String = " "


    //    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_register)
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        auth = FirebaseAuth.getInstance()

        binding!!.txtOptionLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding!!.btnRegister.setOnClickListener {
            email = binding!!.txtEmailInput.text.toString().trim()
            username = binding!!.txtNamaInput.text.toString()
            phone = binding!!.txtPhone.text.toString()
            password = binding!!.txtKonfirmPasword.text.toString().trim()


            when {
                email == "" -> {
                    binding!!.txtEmailInput.error = "Email Tidak Boleh Kosong"
                }
                username == "" -> {
                    binding!!.txtNamaInput.error = "Username Tidak Boleh Kosong"
                }
                phone == "" -> {
                    binding!!.txtPhone.error = "Nomor HP Tidak Boleh Kosong"
                }
                password == " " -> {
                    binding!!.txtKonfirmPasword.error = "Password Tidak Boleh Kosong"
                }
            }
            registerUser(email, password)
        }
    }

    private fun registerUser(email: String, password:String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }
}

//            else -> {
//                    binding!!.loading.visibility = View.VISIBLE
//                    getData()
//                }
//            }
//        }
//    private fun getData() {
//        val api = RetrofitClient().getInstace()
//        api.register(email, username, phone, password).enqueue(object : Callback<ResponseRegister> {
//            override fun onResponse(
//                call: Call<ResponseRegister>,
//                response: Response<ResponseRegister>
//            ) {
//                if (response.isSuccessful) {
//                    if (response.body()?.response == true) {
//                        binding!!.loading.visibility = View.GONE
//                        startActivity(Intent(this@RegisterActivity, BerandaActivity::class.java))
//                    } else {
//                        binding!!.loading.visibility = View.GONE
//                        Toast.makeText(
//                            this@RegisterActivity,
//                            "login gagal, periksa kembali username dan password",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                } else {
//                    Toast.makeText(this@RegisterActivity, "Terjadi Kesalahan", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
//                Log.d("error", "${t.message}")
//            }
//
//        })
//        }
//    }

