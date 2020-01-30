package pers.kindem.zed.runtime.loader.proxy;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class PluginResources extends Resources {
    private static final String TAG = PluginResources.class.getSimpleName();

    private Resources hostResources;
    private Resources injectResources;

    public PluginResources(Resources hostResources, Resources injectResources) {
        super(injectResources.getAssets(), injectResources.getDisplayMetrics(), injectResources.getConfiguration());
        this.hostResources = hostResources;
        this.injectResources = injectResources;
    }

    @Override
    public XmlResourceParser getLayout(int id) throws NotFoundException {
        try {
            return injectResources.getLayout(id);
        } catch (NotFoundException e) {
            return hostResources.getLayout(id);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public int getColor(int id, Theme theme) throws NotFoundException {
        try {
            return injectResources.getColor(id, theme);
        } catch (NotFoundException e) {
            return hostResources.getColor(id, theme);
        }
    }

    @Override
    public String getString(int id, Object... formatArgs) throws NotFoundException {
        try {
            return injectResources.getString(id, formatArgs);
        } catch (NotFoundException e) {
            return hostResources.getString(id, formatArgs);
        }
    }

    @Override
    public String getString(int id) throws NotFoundException {
        try {
            return injectResources.getString(id);
        } catch (NotFoundException e) {
            return hostResources.getString(id);
        }
    }

    @Override
    public String[] getStringArray(int id) throws NotFoundException {
        try {
            return injectResources.getStringArray(id);
        } catch (NotFoundException e) {
            return hostResources.getStringArray(id);
        }
    }

    @Override
    public boolean getBoolean(int id) throws NotFoundException {
        try {
            return injectResources.getBoolean(id);
        } catch (NotFoundException e) {
            return hostResources.getBoolean(id);
        }
    }

    @Override
    public CharSequence getQuantityText(int id, int quantity) throws NotFoundException {
        try {
            return injectResources.getQuantityText(id, quantity);
        } catch (NotFoundException e) {
            return hostResources.getQuantityText(id, quantity);
        }
    }

    @Override
    public String getQuantityString(int id, int quantity) throws NotFoundException {
        try {
            return injectResources.getQuantityString(id, quantity);
        } catch (NotFoundException e) {
            return hostResources.getQuantityString(id, quantity);
        }
    }

    @Override
    public String getQuantityString(int id, int quantity, Object... formatArgs) throws NotFoundException {
        try {
            return injectResources.getQuantityString(id, quantity, formatArgs);
        } catch (NotFoundException e) {
            return hostResources.getQuantityString(id, quantity, formatArgs);
        }
    }

    @Override
    public Configuration getConfiguration() {
        return injectResources.getConfiguration();
    }

    @Override
    public DisplayMetrics getDisplayMetrics() {
        return injectResources.getDisplayMetrics();
    }

    @Override
    public Drawable getDrawableForDensity(int id, int density, Theme theme) {
        try {
            return injectResources.getDrawableForDensity(id, density, theme);
        } catch (NotFoundException e) {
            return hostResources.getDrawableForDensity(id, density, theme);
        }
    }

    @Override
    public float getDimension(int id) throws NotFoundException {
        try {
            return injectResources.getDimension(id);
        } catch (NotFoundException e) {
            return hostResources.getDimension(id);
        }
    }

    @TargetApi(Build.VERSION_CODES.Q)
    @Override
    public float getFloat(int id) {
        try {
            return injectResources.getFloat(id);
        } catch (NotFoundException e) {
            return hostResources.getFloat(id);
        }
    }

    @Override
    public float getFraction(int id, int base, int pbase) {
        try {
            return injectResources.getFraction(id, base, pbase);
        } catch (NotFoundException e) {
            return hostResources.getFraction(id, base, pbase);
        }
    }

    @Override
    public int getDimensionPixelOffset(int id) throws NotFoundException {
        try {
            return injectResources.getDimensionPixelOffset(id);
        } catch (NotFoundException e) {
            return hostResources.getDimensionPixelOffset(id);
        }
    }

    @Override
    public CharSequence getText(int id) throws NotFoundException {
        try {
            return injectResources.getText(id);
        } catch (NotFoundException e) {
            return hostResources.getText(id);
        }
    }

    @Override
    public CharSequence getText(int id, CharSequence def) {
        try {
            return injectResources.getText(id, def);
        } catch (NotFoundException e) {
            return hostResources.getText(id, def);
        }
    }

    @Override
    public CharSequence[] getTextArray(int id) throws NotFoundException {
        try {
            return injectResources.getTextArray(id);
        } catch (NotFoundException e) {
            return hostResources.getTextArray(id);
        }
    }

    @Override
    public int getColor(int id) throws NotFoundException {
        try {
            return injectResources.getColor(id);
        } catch (NotFoundException e) {
            return hostResources.getColor(id);
        }
    }

    @Override
    public Drawable getDrawable(int id) throws NotFoundException {
        try {
            return injectResources.getDrawable(id);
        } catch (NotFoundException e) {
            return hostResources.getDrawable(id);
        }
    }

    @Override
    public Drawable getDrawable(int id, Theme theme) throws NotFoundException {
        try {
            return injectResources.getDrawable(id, theme);
        } catch (NotFoundException e) {
            return hostResources.getDrawable(id, theme);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public ColorStateList getColorStateList(int id, Theme theme) throws NotFoundException {
        try {
            return injectResources.getColorStateList(id, theme);
        } catch (NotFoundException e) {
            return hostResources.getColorStateList(id, theme);
        }
    }

    @Override
    public int getDimensionPixelSize(int id) throws NotFoundException {
        try {
            return injectResources.getDimensionPixelSize(id);
        } catch (NotFoundException e) {
            return hostResources.getDimensionPixelSize(id);
        }
    }

    @Override
    public int getIdentifier(String name, String defType, String defPackage) {
        try {
            return injectResources.getIdentifier(name, defType, defPackage);
        } catch (NotFoundException e) {
            return hostResources.getIdentifier(name, defType, defPackage);
        }
    }

    @Override
    public int getInteger(int id) throws NotFoundException {
        try {
            return injectResources.getInteger(id);
        } catch (NotFoundException e) {
            return hostResources.getInteger(id);
        }
    }

    @Override
    public int[] getIntArray(int id) throws NotFoundException {
        try {
            return injectResources.getIntArray(id);
        } catch (NotFoundException e) {
            return hostResources.getIntArray(id);
        }
    }

    @Override
    public String getResourceEntryName(int resid) throws NotFoundException {
        try {
            return injectResources.getResourceEntryName(resid);
        } catch (NotFoundException e) {
            return hostResources.getResourceEntryName(resid);
        }
    }

    @Override
    public String getResourceName(int resid) throws NotFoundException {
        try {
            return injectResources.getResourceName(resid);
        } catch (NotFoundException e) {
            return hostResources.getResourceName(resid);
        }
    }

    @Override
    public String getResourcePackageName(int resid) throws NotFoundException {
        try {
            return injectResources.getResourcePackageName(resid);
        } catch (NotFoundException e) {
            return hostResources.getResourcePackageName(resid);
        }
    }

    @Override
    public String getResourceTypeName(int resid) throws NotFoundException {
        try {
            return injectResources.getResourceTypeName(resid);
        } catch (NotFoundException e) {
            return  hostResources.getResourceTypeName(resid);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public Typeface getFont(int id) throws NotFoundException {
        try {
            return injectResources.getFont(id);
        } catch (NotFoundException e) {
            return hostResources.getFont(id);
        }
    }

    @Override
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        try {
            injectResources.getValue(id, outValue, resolveRefs);
        } catch (NotFoundException e) {
            hostResources.getValue(id, outValue, resolveRefs);
        }
    }

    @Override
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        try {
            injectResources.getValue(name, outValue, resolveRefs);
        } catch (NotFoundException e) {
            hostResources.getValue(name, outValue, resolveRefs);
        }
    }

    @Override
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        try {
            injectResources.getValueForDensity(id, density, outValue, resolveRefs);
        } catch (NotFoundException e) {
            hostResources.getValueForDensity(id, density, outValue, resolveRefs);
        }
    }

    @Override
    public XmlResourceParser getAnimation(int id) throws NotFoundException {
        try {
            return injectResources.getAnimation(id);
        } catch (NotFoundException e) {
            return hostResources.getAnimation(id);
        }
    }

    @Override
    public XmlResourceParser getXml(int id) throws NotFoundException {
        try {
            return injectResources.getXml(id);
        } catch (NotFoundException e) {
            return hostResources.getXml(id);
        }
    }

    @Override
    public ColorStateList getColorStateList(int id) throws NotFoundException {
        try {
            return injectResources.getColorStateList(id);
        } catch (NotFoundException e) {
            return hostResources.getColorStateList(id);
        }
    }

    @Override
    public Drawable getDrawableForDensity(int id, int density) throws NotFoundException {
        try {
            return injectResources.getDrawableForDensity(id, density);
        } catch (NotFoundException e) {
            return hostResources.getDrawableForDensity(id, density);
        }
    }

    @Override
    public Movie getMovie(int id) throws NotFoundException {
        try {
            return injectResources.getMovie(id);
        } catch (NotFoundException e) {
            return hostResources.getMovie(id);
        }
    }
}
