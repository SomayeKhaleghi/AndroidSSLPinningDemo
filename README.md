# SecureFetch
 
# 🔐 Android SSL Pinning Demo

This is a demo Android application built with **Kotlin** that demonstrates how to protect your app from **Man-in-the-Middle (MITM)** attacks using **SSL Pinning**.

## 📹 YouTube Video

🎥 **Watch the full tutorial on YouTube**: [How to Implement SSL Pinning in Android](https://youtu.be/8Es4C6RUbXk)
## 🚀 Features

- Retrofit-based networking
- Burp Suite traffic capture
- SSL Pinning using `OkHttp` + `CertificatePinner`
- Proxy setup using ADB
- Certificate installation on emulator
- MITM attack simulation and prevention

## 🛠️ Tech Stack

- Kotlin
- Retrofit
- OkHttp
- CertificatePinner
- Android SDK 30+
- Burp Suite

## 📦 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/SomayeKhaleghi/AndroidSSLPinningDemo.git


## 🔧 Shell Commands Used in This Demo

### ⚙️ [Set Up Proxy in Emulator: 8.1]
 Set up proxy:
```bash
adb shell settings put global http_proxy 192.168.29.2:8080
 adb shell settings get global http_proxy


### 🔒 [Install Burp Certificate in Emulator] 
 download burp suit certificate from : http://192.168.29.2:8080/
 rename it to burp_cert.der
 ```bash
 openssl x509 -inform DER -in burp_cert.der -out burp_cert.pem
 openssl x509 -inform PEM -subject_hash_old -in burp_cert.pem | Select-Object -First 1
 mv burp_cert.pem 9a5ba575.0

```bash
 adb root
 adb remount
 adb push 9a5ba575.0 /system/etc/security/cacerts/
 adb shell chmod 644 /system/etc/security/cacerts/9a5ba575.0
 adb reboot
 
### 🛡️ [Add SSL Pinning]
for get https://jsonplaceholder.typicode.com/ certificate fingerprint: 
```bash
openssl x509 -in jsonplaceholder.crt -noout -pubkey | openssl pkey -pubin -outform DER | openssl dgst -sha256 -binary | openssl enc -base64


### ✅ [Remove Proxy]
```bash
adb shell settings put global http_proxy :0  
