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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://accseamless.stage.digitalintegrasiasia.com/h4l4m4nl091nSAdm')

WebUI.delay(3)

WebUI.setText(findTestObject('Object Repository/admin login/input_Login_username'), username)

WebUI.setText(findTestObject('Object Repository/admin login/input_Password_password'), password)

if (expected == 'pass') {
    WebUI.delay(10)

    WebUI.click(findTestObject('Object Repository/admin login/button_Sign in'))

    WebUI.delay(5)

    WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/h1_Welcome To Access CMS'), 0)

    WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/span_Logout'), 0)
} else if (expected == 'fail') {
    WebUI.setText(findTestObject('admin login/input_captcha'), captcha)

    WebUI.delay(3)

    WebUI.click(findTestObject('Object Repository/admin login/button_Sign in'))

    WebUI.delay(3)

    switch (status.toString()) {
        case 'username empty':
            WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/div_The username is required'), 0)

            break
        case 'password empty':
            WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/div_The password is required'), 0)

            break
        case 'captcha empty':
            WebUI.click(findTestObject('Object Repository/admin login/div_The captcha field is required'))

            WebUI.click(findTestObject('Object Repository/admin login/button_Ok'))

            break
        case 'username invalid':
            WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/div_The username must be more than 6 and le_7e1c0c'), 
                0)

            break
        case 'password invalid':
            WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/div_The password must have at least 7 characters'), 
                0)

            break
        case 'captcha invalid':
            WebUI.verifyElementPresent(findTestObject('admin login/div_Captcha tidak benar'), 0)

            WebUI.click(findTestObject('admin login/button_Ok'))

            break
        case 'all empty':
            WebUI.delay(3)

            WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/div_The username is required'), 0)

            WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/div_The password is required'), 0)

            break
        case 'wrong username':
            WebUI.verifyElementPresent(findTestObject('superadmin/div_USER NAME SALAH'), 0)

            WebUI.click(findTestObject('admin login/button_Ok'))

            break
        case 'all input invalid':
            WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/div_The username must be more than 6 and le_7e1c0c'), 
                0)

            WebUI.verifyElementPresent(findTestObject('Object Repository/admin login/div_The password must have at least 7 characters'), 
                0)

            break
        case 'wrong password':
            WebUI.verifyElementPresent(findTestObject('superadmin/div_PASSWORD SALAH'), 0)

            WebUI.click(findTestObject('admin login/button_Ok'))

            break
    }
}

WebUI.closeBrowser()

