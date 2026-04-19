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

Mobile.startApplication('C:\\Users\\LENOVO\\node_modules\\android-apidemos\\bin\\ApiDemos-debug.apk', true)

Mobile.tap(findTestObject('Object Repository/new object/android.widget.Button - OK'), 0)

Mobile.tap(findTestObject('Object Repository/new object/android.widget.TextView - Views'), 0)

Mobile.tap(findTestObject('Object Repository/new object/android.widget.TextView - Gallery'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/new object/android.widget.TextView - 1. Photos'), 5)

Mobile.tap(findTestObject('Object Repository/new object/android.widget.TextView - 1. Photos'), 0)

Mobile.clearText(findTestObject('Object Repository/new object/android.widget.EditText - false'), 0)

Mobile.setText(findTestObject('Object Repository/new object/android.widget.EditText'), 'tester', 0)

Mobile.hideKeyboard()

Mobile.verifyElementText(findTestObject('Object Repository/new object/android.widget.EditText'), 'tester')

Mobile.delay(0.5)

Mobile.tap(findTestObject('Object Repository/new object/android.widget.ImageView (1)'), 0)

Mobile.pressBack()

Mobile.verifyElementVisible(findTestObject('Object Repository/new object/android.widget.TextView - 2. People'), 5)

Mobile.tap(findTestObject('Object Repository/new object/android.widget.TextView - 2. People'), 0)

Mobile.pressBack()

Mobile.tap(findTestObject('Object Repository/new object/android.widget.TextView - 1. Photos'), 0)

Mobile.pressBack()

Mobile.delay(1)

Mobile.closeApplication()

