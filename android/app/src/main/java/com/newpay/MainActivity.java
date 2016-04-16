package com.newpay;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;
import br.com.vizir.rn.paypal.PayPalPackage; // <--
import br.com.vizir.rn.paypal.PayPal; // <--
import android.content.Intent; // <--

public class MainActivity extends ReactActivity {

    private static final int PAY_PAL_REQUEST_ID = 9;
    private PayPalPackage payPalPackage;
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "newpay";
    }

    /**
     * Returns whether dev mode should be enabled.
     * This enables e.g. the dev menu.
     */
    @Override
    protected boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

    /**
     * A list of packages used by the app. If the app uses additional views
     * or modules besides the default ones, add more packages here.
     */
    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
            new MainReactPackage(),
            new PayPalPackage(this, PAY_PAL_REQUEST_ID)
        );
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
       if (requestCode == PAY_PAL_REQUEST_ID) {
           payPalPackage.handleActivityResult(requestCode, resultCode, data); // <--
       } else {
           otherModulesHandlers(requestCode, resultCode, data);
       }
    }
}
