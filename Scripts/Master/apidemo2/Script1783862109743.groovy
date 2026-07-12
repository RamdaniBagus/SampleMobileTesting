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

TestData data = findTestData('Data Files/Data_Shakespeare')

Mobile.startApplication(GlobalVariable.apkPath, true)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.Button - OK'), 0)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.TextView - Graphics'), 0)

Mobile.scrollToText('Sweep')

Mobile.scrollToText('arcs')

Mobile.pressBack()

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.TextView - App (1)'), 0)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.TextView - Fragment'), 0)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.TextView - List Array'), 0)

// DDT Loop untuk membaca semua data Shakespeare
for (int i = 1; i <= data.getRowNumbers(); i++) {
    String expectedText = data.getValue('Text', i)
    String menuName = data.getValue('Menu', i)
    
    Mobile.comment("Mencari: ${menuName} - ${expectedText}")
    
    Mobile.scrollToText(expectedText)
    
    // Verifikasi elemen
    boolean isVisible = Mobile.verifyElementVisible(
        findTestObject('Object Repository/apidemo2/android.widget.TextView - Dynamic', 
            [('text'): expectedText]), 
        3, 
        FailureHandling.CONTINUE_ON_FAILURE
    )
    
    if (isVisible) {
        String actualText = Mobile.getText(
            findTestObject('Object Repository/apidemo2/android.widget.TextView - Dynamic', 
                [('text'): expectedText]), 
            0
        )
        Mobile.comment("✓ VALID: ${actualText} berhasil ditemukan")
    } else {
        Mobile.comment("✗ GAGAL: ${expectedText} tidak ditemukan")
    }
}

Mobile.pressBack()

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.TextView - Alert Dialog'), 0)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.Button - SHOW'), 0)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.Button - OK (1)'), 0)

Mobile.pressBack()

Mobile.delay(1)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.TextView - Nesting Tabs'), 0)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.TextView - TABS'), 0)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.TextView - APPS'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/apidemo2/android.widget.LinearLayout'), 3)

Mobile.getText(findTestObject('Object Repository/apidemo2/android.widget.LinearLayout'), 0)

Mobile.scrollToText('vessel')

Mobile.scrollToText('2 button')

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.TextView'), 0)

Mobile.getText(findTestObject('Object Repository/apidemo2/android.widget.TextView - Black'), 0)

Mobile.tap(findTestObject('Object Repository/apidemo2/android.widget.ImageView (2)'), 0)

Mobile.hideKeyboard()

Mobile.pressBack()

Mobile.delay(1)

Mobile.closeApplication()