package com.thesun.chat_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.thesun.chat_app.presentation.chat.ChatScreen
import com.thesun.chat_app.presentation.username.UsernameScreen
import com.thesun.chat_app.ui.theme.Chat_AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Chat_AppTheme {
                Scaffold { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "username_screen"
                        ) {
                            composable("username_screen") {
                                UsernameScreen(onNavigate = navController::navigate)
                            }
                            composable(
                                route = "chat_screen/{username}",
                                arguments = listOf(
                                    navArgument(name = "username") {
                                        type = NavType.StringType
                                        nullable = true
                                    }
                                )
                            ) {
                                val username = it.arguments?.getString("username")
                                ChatScreen(username)
                            }
                        }
                    }
                }

            }
        }
    }
}
