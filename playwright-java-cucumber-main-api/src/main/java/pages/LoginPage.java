package pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import utils.WebActions;

public class LoginPage{
    private Page page;
    private BrowserContext context;
    private final Locator USERNAME_EDITBOX;
    private final Locator PASSWORD_EDITBOX;
    private final Locator LOGIN_BUTTON;
    private final Locator HUDL_OPTION;
    private final Locator PROFILE_ICON;
    private final Locator LOGOUT_BUTTON;

    public LoginPage(Page page) {
        this.page = page;
        this.USERNAME_EDITBOX = page.locator("#email");
        this.PASSWORD_EDITBOX = page.locator("#password");
        this.LOGIN_BUTTON = page.getByText("Log in");
        this.HUDL_OPTION=page.getByText("Hudl");
        this.PROFILE_ICON=page.locator("div.hui-globalusermenu");
        this.LOGOUT_BUTTON=page.locator("span:has-text('Log Out')").first();
    }

    public void navigateToUrl(String url) {
        this.page.navigate(WebActions.getProperty(url), new Page.NavigateOptions().setTimeout(30000));
        this.LOGIN_BUTTON.waitFor(new Locator.WaitForOptions().setTimeout(30000).setState(WaitForSelectorState.VISIBLE));
    }

    public void enterUsername(String username) {
        USERNAME_EDITBOX.fill(WebActions.getProperty(username));
    }

    public void enterPassword(String password) {
        PASSWORD_EDITBOX.fill(WebActions.decrypt(password));
    }

    public void clickLogin() {
        LOGIN_BUTTON.click();
    }

    public void clickContinueButton() {
        this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
    }

    public void clickHudl(){
        Page newPage = this.context.waitForPage(() -> {HUDL_OPTION.click();});
        newPage.waitForLoadState();
    }

    public void clickOnIcon(String iconName) {
        this.page.locator("[data-qa-id='login-hudl']").click();
    }

    public boolean verifyMainPage() {
        return WebActions.waitUntilElementDisplayed(this.USERNAME_EDITBOX, 60);
    }

    public boolean verifyUserProfilePage() {
        return WebActions.waitUntilElementDisplayed(this.PROFILE_ICON, 60);
    }

    public void clickLoginOut() {
        PROFILE_ICON.hover();
        LOGOUT_BUTTON.click();
    }
}
