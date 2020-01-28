package pers.kindem.zed.runtime.loader.proxy;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;

public class PluginResources extends Resources {
    private static final String TAG = PluginResources.class.getSimpleName();

    private Resources hostResources;
    private Resources injectResources;

    public PluginResources(Resources hostResources, Resources injectResources) {
        super(hostResources.getAssets(), hostResources.getDisplayMetrics(), hostResources.getConfiguration());
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
            return hostResources.getText(id);
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
}
