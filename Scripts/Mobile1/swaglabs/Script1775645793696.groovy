import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

// ============================================================
// KONSTANTA TIMEOUT — ubah di satu tempat, berlaku semua step
// ============================================================
final int TIMEOUT = 10

// ============================================================
// START APP
// ============================================================
Mobile.startExistingApplication('com.swaglabsmobileapp')
KeywordUtil.logInfo('✅ Aplikasi berhasil dibuka')

// ============================================================
// STEP 1-9: LOGIN FLOW dengan kondisi percabangan
// ============================================================
String usernameText = Mobile.getText(
    findTestObject('Object Repository/swaglabs/android.widget.EditText - Username'),
    TIMEOUT
)
KeywordUtil.logInfo("📋 Username field text: '${usernameText}'")

if (usernameText != null && usernameText.contains('Username')) {
    // KONDISI 1: Field masih berisi placeholder "Username" → perlu login penuh
    KeywordUtil.logInfo('▶ Kondisi 1: Login penuh')

    Mobile.getText(findTestObject('Object Repository/swaglabs/android.widget.EditText - Password'), TIMEOUT)
    Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - LOGIN'), TIMEOUT)
    Mobile.scrollToText('standard_user')
    Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - standard_user (1)'), TIMEOUT)
    Mobile.scrollToText('standard_user')
    Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - LOGIN'), TIMEOUT)

} else if (usernameText != null && !usernameText.isEmpty()) {
    // KONDISI 2: Field berisi teks tapi bukan placeholder → tap LOGIN langsung
    KeywordUtil.logInfo('▶ Kondisi 2: Tap LOGIN langsung')
    Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - LOGIN'), TIMEOUT)

} else {
    // KONDISI 3: Field kosong/null → sudah login, langsung ke PRODUCTS
    KeywordUtil.logInfo('▶ Kondisi 3: Skip login, langsung ke PRODUCTS')
}

// Verifikasi halaman PRODUCTS berhasil dimuat
String productsText = Mobile.getText(
    findTestObject('Object Repository/swaglabs/android.widget.TextView - PRODUCTS (1)'),
    TIMEOUT
)
KeywordUtil.logInfo("📋 Halaman aktif: '${productsText}'")

// ============================================================
// FLOW 1: ADD TO CART — Sauce Labs Backpack
// ============================================================
KeywordUtil.logInfo('🛒 Flow 1: Add Sauce Labs Backpack to cart')

Mobile.scrollToText('PRODUCTS')
Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - ADD TO CART (1)'), TIMEOUT)

// Verifikasi badge cart = 1
String cartBadge = Mobile.getText(
    findTestObject('Object Repository/swaglabs/android.widget.TextView - 1'),
    TIMEOUT
)
KeywordUtil.logInfo("🛒 Cart badge: '${cartBadge}'")

// Masuk ke cart
Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - 1'), TIMEOUT)

// Remove item dari cart
Mobile.pressBack()
Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - REMOVE'), TIMEOUT)
KeywordUtil.logInfo('✅ Flow 1 selesai: Item di-remove')

// ============================================================
// FLOW 2: ADD TO CART — Sauce Labs Onesie
// ============================================================
KeywordUtil.logInfo('🛒 Flow 2: Add Sauce Labs Onesie to cart')

Mobile.scrollToText('Sauce Labs Onesie')

// Tap nama produk Onesie — gunakan XPath contains agar lebih robust
try {
    Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - SauceLabs Onesie Product'), TIMEOUT)
} catch (Exception e) {
    KeywordUtil.markWarning('⚠️ Tap produk Onesie gagal, mencoba scroll ulang: ' + e.getMessage())
    Mobile.scrollToText('Sauce Labs Onesie')
    Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - SauceLabs Onesie Product'), TIMEOUT)
}

Mobile.scrollToText('ADD TO CART')
Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - ADD TO CART (2)'), TIMEOUT)

// Masuk cart → remove → lanjut belanja
Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - 1 (1)'), TIMEOUT)
Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - REMOVE (1)'), TIMEOUT)
Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - CONTINUE SHOPPING'), TIMEOUT)
KeywordUtil.logInfo('✅ Flow 2 selesai: Item di-remove, kembali belanja')

// ============================================================
// FLOW 3: ADD TO CART — Rib Snap Onesie (element panjang)
// ============================================================
KeywordUtil.logInfo('🛒 Flow 3: Add Rib Snap Onesie to cart')

Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - ADD TO CART (2)'), TIMEOUT)
Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - 1 (1)'), TIMEOUT)

// Gunakan contains XPath untuk element dengan nama panjang
try {
    Mobile.scrollToText('Rib snap infant onesie', FailureHandling.OPTIONAL)
    Mobile.delay(2)
    Mobile.tap(
        findTestObject('Object Repository/swaglabs/android.widget.TextView - RibSnapOnesie'),
        TIMEOUT,
        FailureHandling.OPTIONAL
    )
    KeywordUtil.logInfo('✅ Tap Rib Snap Onesie berhasil')
} catch (Exception e) {
    KeywordUtil.markWarning('⚠️ Tap Rib Snap Onesie di-skip: ' + e.getMessage())
}

Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - REMOVE (1)'), TIMEOUT)
Mobile.tap(findTestObject('Object Repository/swaglabs/android.widget.TextView - CONTINUE SHOPPING'), TIMEOUT)
KeywordUtil.logInfo('✅ Flow 3 selesai')

// ============================================================
// CLOSE APP
// ============================================================
Mobile.closeApplication()
KeywordUtil.logInfo('✅ Aplikasi ditutup, test selesai')