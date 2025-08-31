package com.example.jz25

import androidx.compose.runtime.Composable
import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType

@Composable
actual fun CheckPermissions() {
    val status = AVCaptureDevice.authorizationStatusForMediaType(AVMediaTypeVideo)
    if (status != AVAuthorizationStatusAuthorized) {
        AVCaptureDevice.requestAccessForMediaType(AVMediaTypeVideo) { granted ->
            if (granted) {
                println("GRANTED")
            } else {
                println("DENIED")
            }
        }
    }

}