package com.roblesdotdev.auth.presentation.intro

sealed interface IntroUIAction {
    data object OnLoginClick: IntroUIAction
    data object OnRegisterClick: IntroUIAction
}