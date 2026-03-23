package np.com.nishanroka

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import np.com.nishanroka.screens.*

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Signup : Screen("signup")
    object Home : Screen("home")
    object Play : Screen("play")
    object LearnChords : Screen("learn_chords")
    object About : Screen("about")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(onTimeout = {
                navController.navigate(Screen.Signup.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }
        composable(Screen.Signup.route) {
            SignupScreen(
                onSignupSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Signup.route) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                onPlayClick = { navController.navigate(Screen.Play.route) },
                onLearnClick = { navController.navigate(Screen.LearnChords.route) },
                onAboutClick = { navController.navigate(Screen.About.route) }
            )
        }
        composable(Screen.Play.route) {
            PlayScreen(onBack = { navController.popBackStack() })
        }
        composable(Screen.LearnChords.route) {
            LearnChordsScreen(onBack = { navController.popBackStack() })
        }
        composable(Screen.About.route) {
            AboutScreen(onBack = { navController.popBackStack() })
        }
    }
}
