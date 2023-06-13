package org.d3if0097.pt2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import org.d3if0097.pt2.databinding.FragmentLoginBinding
import org.d3if0097.pt2.model.ResponseLogin
import org.d3if0097.pt2.network.RetrofitClient
import org.d3if0097.pt2.ui.home.HomeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private var binding: FragmentLoginBinding? = null
    private var email: String = " "
    private var password: String = " "

    //    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        auth = FirebaseAuth.getInstance()
        binding!!.btnRegis.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
        binding!!.btnLogin.setOnClickListener {
            email = binding!!.txtEmailInput.text.toString().trim()
            password = binding!!.txtPswInput.text.toString().trim()

            when {
                email == "" -> {
                    binding!!.txtEmailInput.error = "Username Tidak Boleh Kosong"
                }
                password == "" -> {
                    binding!!.txtPswInput.error = "Password Tidak Boleh Kosong"
                }
            }
            loginUser(email,password)
        }
    }

//    override fun onStart() {
//        super.onStart()
//        if (auth.currentUser !=null) {
//            Intent(this, LoginActivity::class.java).also {
//                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                startActivity(it)
//            }
//        }
//    }

        private fun loginUser(email:String, password:String) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {  login ->
                    if (login.isSuccessful) {
                        Intent(this, BerandaActivity::class.java).also {
                            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                            Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, login.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
        }

        private fun getData() {
            val api = RetrofitClient().getInstace()
            api.login(email, password).enqueue(object : Callback<ResponseLogin> {
                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()?.response == true) {
                            binding!!.loading.visibility = View.GONE
                            startActivity(Intent(this@LoginActivity, BerandaActivity::class.java))
                        } else {
                            binding!!.loading.visibility = View.GONE
                            Toast.makeText(
                                this@LoginActivity,
                                "login gagal, periksa kembali username dan password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(this@LoginActivity, "Terjadi Kesalahan", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                    Log.d("error", "${t.message}")
                }

            })
        }

    }
