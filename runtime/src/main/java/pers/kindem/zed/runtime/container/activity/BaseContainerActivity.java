package pers.kindem.zed.runtime.container.activity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Dialog;
import android.app.DirectAction;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.PersistableBundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;

import java.util.List;
import java.util.function.Consumer;

public class BaseContainerActivity extends Activity implements ContainerActivityCallback {
    protected PluginActivity pluginActivity;

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        if (pluginActivity != null) {
            return pluginActivity.dispatchGenericMotionEvent(ev);
        } else {
            return super.dispatchGenericMotionEvent(ev);
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.dispatchKeyEvent(event);
        } else {
            return super.dispatchKeyEvent(event);
        }
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.dispatchKeyShortcutEvent(event);
        } else {
            return super.dispatchKeyShortcutEvent(event);
        }
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.dispatchPopulateAccessibilityEvent(event);
        } else {
            return super.dispatchPopulateAccessibilityEvent(event);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (pluginActivity != null) {
            return pluginActivity.dispatchTouchEvent(ev);
        } else {
            return super.dispatchTouchEvent(ev);
        }
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        if (pluginActivity != null) {
            return pluginActivity.dispatchTrackballEvent(ev);
        } else {
            return super.dispatchTrackballEvent(ev);
        }
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        if (pluginActivity != null) {
            pluginActivity.onActionModeFinished(mode);
        } else {
            super.onActionModeFinished(mode);
        }
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        if (pluginActivity != null) {
            pluginActivity.onActionModeStarted(mode);
        } else {
            super.onActionModeStarted(mode);
        }
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        if (pluginActivity != null) {
            pluginActivity.onActivityReenter(resultCode, data);
        } else {
            super.onActivityReenter(resultCode, data);
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (pluginActivity != null) {
            pluginActivity.onAttachFragment(fragment);
        } else {
            super.onAttachFragment(fragment);
        }
    }

    @Override
    public void onAttachedToWindow() {
        if (pluginActivity != null) {
            pluginActivity.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override
    public void onBackPressed() {
        if (pluginActivity != null) {
            pluginActivity.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (pluginActivity != null) {
            pluginActivity.onConfigurationChanged(newConfig);
        } else {
            super.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onContentChanged() {
        if (pluginActivity != null) {
            pluginActivity.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (pluginActivity != null) {
            return pluginActivity.onContextItemSelected(item);
        } else {
            return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        if (pluginActivity != null) {
            pluginActivity.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (pluginActivity != null) {
            pluginActivity.onCreate(savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (pluginActivity != null) {
            pluginActivity.onCreate(savedInstanceState, persistentState);
        } else {
            super.onCreate(savedInstanceState, persistentState);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (pluginActivity != null) {
            pluginActivity.onCreateContextMenu(menu, v, menuInfo);
        } else {
            super.onCreateContextMenu(menu, v, menuInfo);
        }
    }

    @Override
    public CharSequence onCreateDescription() {
        if (pluginActivity != null) {
            return pluginActivity.onCreateDescription();
        } else {
            return super.onCreateDescription();
        }
    }

    @Override
    public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
        if (pluginActivity != null) {
            pluginActivity.onCreateNavigateUpTaskStack(builder);
        } else {
            super.onCreateNavigateUpTaskStack(builder);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (pluginActivity != null) {
            return pluginActivity.onCreateOptionsMenu(menu);
        } else {
            return super.onCreateOptionsMenu(menu);
        }
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (pluginActivity != null) {
            return pluginActivity.onCreatePanelMenu(featureId, menu);
        } else {
            return super.onCreatePanelMenu(featureId, menu);
        }
    }

    @Override
    public View onCreatePanelView(int featureId) {
        if (pluginActivity != null) {
            return pluginActivity.onCreatePanelView(featureId);
        } else {
            return super.onCreatePanelView(featureId);
        }
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        if (pluginActivity != null) {
            return pluginActivity.onCreateThumbnail(outBitmap, canvas);
        } else {
            return super.onCreateThumbnail(outBitmap, canvas);
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        if (pluginActivity != null) {
            return pluginActivity.onCreateView(parent, name, context, attrs);
        } else {
            return super.onCreateView(parent, name, context, attrs);
        }
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        if (pluginActivity != null) {
            return pluginActivity.onCreateView(name, context, attrs);
        } else {
            return super.onCreateView(name, context, attrs);
        }
    }

    @Override
    public void onDetachedFromWindow() {
        if (pluginActivity != null) {
            pluginActivity.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override
    public void onEnterAnimationComplete() {
        if (pluginActivity != null) {
            pluginActivity.onEnterAnimationComplete();
        } else {
            super.onEnterAnimationComplete();
        }
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.onGenericMotionEvent(event);
        } else {
            return super.onGenericMotionEvent(event);
        }
    }

    @Override
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer<List<DirectAction>> callback) {
        if (pluginActivity != null) {
            pluginActivity.onGetDirectActions(cancellationSignal, callback);
        } else {
            super.onGetDirectActions(cancellationSignal, callback);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.onKeyDown(keyCode, event);
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.onKeyLongPress(keyCode, event);
        } else {
            return super.onKeyLongPress(keyCode, event);
        }
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.onKeyMultiple(keyCode, repeatCount, event);
        } else {
            return super.onKeyMultiple(keyCode, repeatCount, event);
        }
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.onKeyShortcut(keyCode, event);
        } else {
            return super.onKeyShortcut(keyCode, event);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.onKeyUp(keyCode, event);
        } else {
            return super.onKeyUp(keyCode, event);
        }
    }

    @Override
    public void onLocalVoiceInteractionStarted() {
        if (pluginActivity != null) {
            pluginActivity.onLocalVoiceInteractionStarted();
        } else {
            super.onLocalVoiceInteractionStarted();
        }
    }

    @Override
    public void onLocalVoiceInteractionStopped() {
        if (pluginActivity != null) {
            pluginActivity.onLocalVoiceInteractionStopped();
        } else {
            super.onLocalVoiceInteractionStopped();
        }
    }

    @Override
    public void onLowMemory() {
        if (pluginActivity != null) {
            pluginActivity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (pluginActivity != null) {
            return pluginActivity.onMenuItemSelected(featureId, item);
        } else {
            return super.onMenuItemSelected(featureId, item);
        }
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (pluginActivity != null) {
            return pluginActivity.onMenuOpened(featureId, menu);
        } else {
            return super.onMenuOpened(featureId, menu);
        }
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        if (pluginActivity != null) {
            pluginActivity.onMultiWindowModeChanged(isInMultiWindowMode);
        } else {
            super.onMultiWindowModeChanged(isInMultiWindowMode);
        }
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        if (pluginActivity != null) {
            pluginActivity.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
        } else {
            super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
        }
    }

    @Override
    public boolean onNavigateUp() {
        if (pluginActivity != null) {
            return pluginActivity.onNavigateUp();
        } else {
            return super.onNavigateUp();
        }
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        if (pluginActivity != null) {
            return pluginActivity.onNavigateUpFromChild(child);
        } else {
            return super.onNavigateUpFromChild(child);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (pluginActivity != null) {
            return pluginActivity.onOptionsItemSelected(item);
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        if (pluginActivity != null) {
            pluginActivity.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        if (pluginActivity != null) {
            pluginActivity.onPanelClosed(featureId, menu);
        } else {
            super.onPanelClosed(featureId, menu);
        }
    }

    @Override
    public void onPerformDirectAction(String actionId, Bundle arguments, CancellationSignal cancellationSignal, Consumer<Bundle> resultListener) {
        if (pluginActivity != null) {
            pluginActivity.onPerformDirectAction(actionId, arguments, cancellationSignal, resultListener);
        } else {
            super.onPerformDirectAction(actionId, arguments, cancellationSignal, resultListener);
        }
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        if (pluginActivity != null) {
            pluginActivity.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        } else {
            super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        }
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        if (pluginActivity != null) {
            pluginActivity.onPictureInPictureModeChanged(isInPictureInPictureMode);
        } else {
            super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        if (pluginActivity != null) {
            pluginActivity.onPostCreate(savedInstanceState);
        } else {
            super.onPostCreate(savedInstanceState);
        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (pluginActivity != null) {
            pluginActivity.onPostCreate(savedInstanceState, persistentState);
        } else {
            super.onPostCreate(savedInstanceState, persistentState);
        }
    }

    @Override
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
        if (pluginActivity != null) {
            pluginActivity.onPrepareNavigateUpTaskStack(builder);
        } else {
            super.onPrepareNavigateUpTaskStack(builder);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (pluginActivity != null) {
            return pluginActivity.onPrepareOptionsMenu(menu);
        } else {
            return super.onPrepareOptionsMenu(menu);
        }
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (pluginActivity != null) {
            return pluginActivity.onPreparePanel(featureId, view, menu);
        } else {
            return super.onPreparePanel(featureId, view, menu);
        }
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        if (pluginActivity != null) {
            pluginActivity.onProvideAssistContent(outContent);
        } else {
            super.onProvideAssistContent(outContent);
        }
    }

    @Override
    public void onProvideAssistData(Bundle data) {
        if (pluginActivity != null) {
            pluginActivity.onProvideAssistData(data);
        } else {
            super.onProvideAssistData(data);
        }
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        if (pluginActivity != null) {
            pluginActivity.onProvideKeyboardShortcuts(data, menu, deviceId);
        } else {
            super.onProvideKeyboardShortcuts(data, menu, deviceId);
        }
    }

    @Override
    public Uri onProvideReferrer() {
        if (pluginActivity != null) {
            return pluginActivity.onProvideReferrer();
        } else {
            return super.onProvideReferrer();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (pluginActivity != null) {
            pluginActivity.onRequestPermissionsResult(requestCode, permissions, grantResults);
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (pluginActivity != null) {
            pluginActivity.onRestoreInstanceState(savedInstanceState);
        } else {
            super.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        if (pluginActivity != null) {
            pluginActivity.onRestoreInstanceState(savedInstanceState, persistentState);
        } else {
            super.onRestoreInstanceState(savedInstanceState, persistentState);
        }
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        if (pluginActivity != null) {
            return pluginActivity.onRetainNonConfigurationInstance();
        } else {
            return super.onRetainNonConfigurationInstance();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (pluginActivity != null) {
            pluginActivity.onSaveInstanceState(outState);
        } else {
            super.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if (pluginActivity != null) {
            pluginActivity.onSaveInstanceState(outState, outPersistentState);
        } else {
            super.onSaveInstanceState(outState, outPersistentState);
        }
    }

    @Override
    public boolean onSearchRequested() {
        if (pluginActivity != null) {
            return pluginActivity.onSearchRequested();
        } else {
            return super.onSearchRequested();
        }
    }

    @Override
    public boolean onSearchRequested(SearchEvent searchEvent) {
        if (pluginActivity != null) {
            return pluginActivity.onSearchRequested(searchEvent);
        } else {
            return super.onSearchRequested(searchEvent);
        }
    }

    @Override
    public void onStateNotSaved() {
        if (pluginActivity != null) {
            pluginActivity.onStateNotSaved();
        } else {
            super.onStateNotSaved();
        }
    }

    @Override
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        if (pluginActivity != null) {
            pluginActivity.onTopResumedActivityChanged(isTopResumedActivity);
        } else {
            super.onTopResumedActivityChanged(isTopResumedActivity);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.onTouchEvent(event);
        } else {
            return super.onTouchEvent(event);
        }
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        if (pluginActivity != null) {
            return pluginActivity.onTrackballEvent(event);
        } else {
            return super.onTrackballEvent(event);
        }
    }

    @Override
    public void onTrimMemory(int level) {
        if (pluginActivity != null) {
            pluginActivity.onTrimMemory(level);
        } else {
            super.onTrimMemory(level);
        }
    }

    @Override
    public void onUserInteraction() {
        if (pluginActivity != null) {
            pluginActivity.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override
    public void onVisibleBehindCanceled() {
        if (pluginActivity != null) {
            pluginActivity.onVisibleBehindCanceled();
        } else {
            super.onVisibleBehindCanceled();
        }
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        if (pluginActivity != null) {
            pluginActivity.onWindowAttributesChanged(params);
        } else {
            super.onWindowAttributesChanged(params);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (pluginActivity != null) {
            pluginActivity.onWindowFocusChanged(hasFocus);
        } else {
            super.onWindowFocusChanged(hasFocus);
        }
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (pluginActivity != null) {
            return pluginActivity.onWindowStartingActionMode(callback);
        } else {
            return super.onWindowStartingActionMode(callback);
        }
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
        if (pluginActivity != null) {
            return pluginActivity.onWindowStartingActionMode(callback, type);
        } else {
            return super.onWindowStartingActionMode(callback, type);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        if (pluginActivity != null) {
            pluginActivity.attachBaseContext(newBase);
        } else {
            super.attachBaseContext(newBase);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (pluginActivity != null) {
            pluginActivity.onActivityResult(requestCode, resultCode, data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        if (pluginActivity != null) {
            pluginActivity.onApplyThemeResource(theme, resid, first);
        } else {
            super.onApplyThemeResource(theme, resid, first);
        }
    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        if (pluginActivity != null) {
            pluginActivity.onChildTitleChanged(childActivity, title);
        } else {
            super.onChildTitleChanged(childActivity, title);
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (pluginActivity != null) {
            return pluginActivity.onCreateDialog(id);
        } else {
            return super.onCreateDialog(id);
        }
    }

    @Override
    protected Dialog onCreateDialog(int id, Bundle args) {
        if (pluginActivity != null) {
            return pluginActivity.onCreateDialog(id, args);
        } else {
            return super.onCreateDialog(id, args);
        }
    }

    @Override
    protected void onDestroy() {
        if (pluginActivity != null) {
            pluginActivity.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (pluginActivity != null) {
            pluginActivity.onNewIntent(intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override
    protected void onPause() {
        if (pluginActivity != null) {
            pluginActivity.onPause();
        } else {
            super.onPause();
        }
    }

    @Override
    protected void onPostResume() {
        if (pluginActivity != null) {
            pluginActivity.onPostResume();
        } else {
            super.onPostResume();
        }
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        if (pluginActivity != null) {
            pluginActivity.onPrepareDialog(id, dialog);
        } else {
            super.onPrepareDialog(id, dialog);
        }
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
        if (pluginActivity != null) {
            pluginActivity.onPrepareDialog(id, dialog, args);
        } else {
            super.onPrepareDialog(id, dialog, args);
        }
    }

    @Override
    protected void onRestart() {
        if (pluginActivity != null) {
            pluginActivity.onRestart();
        } else {
            super.onRestart();
        }
    }

    @Override
    protected void onResume() {
        if (pluginActivity != null) {
            pluginActivity.onResume();
        } else {
            super.onResume();
        }
    }

    @Override
    protected void onStart() {
        if (pluginActivity != null) {
            pluginActivity.onStart();
        } else {
            super.onStart();
        }
    }

    @Override
    protected void onStop() {
        if (pluginActivity != null) {
            pluginActivity.onStop();
        } else {
            super.onStop();
        }
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        if (pluginActivity != null) {
            pluginActivity.onTitleChanged(title, color);
        } else {
            super.onTitleChanged(title, color);
        }
    }

    @Override
    protected void onUserLeaveHint() {
        if (pluginActivity != null) {
            pluginActivity.onUserLeaveHint();
        } else {
            super.onUserLeaveHint();
        }
    }

    @Override
    public void pureAddContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    public void pureCloseContextMenu() {
        super.closeContextMenu();
    }

    @Override
    public void pureCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    @Override
    public PendingIntent pureCreatePendingResult(int requestCode, Intent data, int flags) {
        return super.createPendingResult(requestCode, data, flags);
    }

    @Override
    public void pureDismissDialog(int id) throws IllegalArgumentException {
        super.dismissDialog(id);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureDismissKeyboardShortcutsHelper() {
        super.dismissKeyboardShortcutsHelper();
    }

    @Override
    public boolean pureDispatchGenericMotionEvent(MotionEvent ev) {
        return super.dispatchGenericMotionEvent(ev);
    }

    @Override
    public boolean pureDispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean pureDispatchKeyShortcutEvent(KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean pureDispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    @Override
    public boolean pureDispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean pureDispatchTrackballEvent(MotionEvent ev) {
        return super.dispatchTrackballEvent(ev);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public boolean pureEnterPictureInPictureMode(PictureInPictureParams params) {
        return super.enterPictureInPictureMode(params);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureEnterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }

    @Override
    public <T extends View> T pureFindViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    public void pureFinish() {
        super.finish();
    }

    @Override
    public void pureFinishActivity(int requestCode) {
        super.finishActivity(requestCode);
    }

    @Override
    public void pureFinishActivityFromChild(Activity child, int requestCode) {
        super.finishActivityFromChild(child, requestCode);
    }

    @Override
    public void pureFinishAffinity() {
        super.finishAffinity();
    }

    @Override
    public void pureFinishAfterTransition() {
        super.finishAfterTransition();
    }

    @Override
    public void pureFinishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    @Override
    public void pureFinishFromChild(Activity child) {
        super.finishFromChild(child);
    }

    @Override
    public ActionBar pureGetActionBar() {
        return super.getActionBar();
    }

    @Override
    public Application pureGetApplication() {
        return super.getApplication();
    }

    @Override
    public ComponentName pureGetCallingActivity() {
        return super.getCallingActivity();
    }

    @Override
    public String pureGetCallingPackage() {
        return super.getCallingPackage();
    }

    @Override
    public int pureGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override
    public ClassLoader pureGetClassLoader() {
        return super.getClassLoader();
    }

    @Override
    public ComponentName pureGetComponentName() {
        return super.getComponentName();
    }

    @Override
    public Scene pureGetContentScene() {
        return super.getContentScene();
    }

    @Override
    public TransitionManager pureGetContentTransitionManager() {
        return super.getContentTransitionManager();
    }

    @Override
    public View pureGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    @Override
    public FragmentManager pureGetFragmentManager() {
        return super.getFragmentManager();
    }

    @Override
    public Intent pureGetIntent() {
        return super.getIntent();
    }

    @Override
    public Object pureGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    @Override
    public LayoutInflater pureGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    @Override
    public LoaderManager pureGetLoaderManager() {
        return super.getLoaderManager();
    }

    @Override
    public String pureGetLocalClassName() {
        return super.getLocalClassName();
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public int pureGetMaxNumPictureInPictureActions() {
        return super.getMaxNumPictureInPictureActions();
    }

    @Override
    public MediaController pureGetMediaController() {
        return super.getMediaController();
    }

    @Override
    public MenuInflater pureGetMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public Activity pureGetParent() {
        return super.getParent();
    }

    @Override
    public Intent pureGetParentActivityIntent() {
        return super.getParentActivityIntent();
    }

    @Override
    public SharedPreferences pureGetPreferences(int mode) {
        return super.getPreferences(mode);
    }

    @Override
    public Uri pureGetReferrer() {
        return super.getReferrer();
    }

    @Override
    public int pureGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public SearchEvent pureGetSearchEvent() {
        return super.getSearchEvent();
    }

    @Override
    public Object pureGetSystemService(String name) {
        return super.getSystemService(name);
    }

    @Override
    public int pureGetTaskId() {
        return super.getTaskId();
    }

    @Override
    public Resources.Theme pureGetTheme() {
        return super.getTheme();
    }

    @Override
    public CharSequence pureGetTitle() {
        return super.getTitle();
    }

    @Override
    public int pureGetTitleColor() {
        return super.getTitleColor();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public VoiceInteractor pureGetVoiceInteractor() {
        return super.getVoiceInteractor();
    }

    @Override
    public int pureGetVolumeControlStream() {
        return super.getVolumeControlStream();
    }

    @Override
    public Window pureGetWindow() {
        return super.getWindow();
    }

    @Override
    public WindowManager pureGetWindowManager() {
        return super.getWindowManager();
    }

    @Override
    public boolean pureHasWindowFocus() {
        return super.hasWindowFocus();
    }

    @Override
    public void pureInvalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public boolean pureIsActivityTransitionRunning() {
        return super.isActivityTransitionRunning();
    }

    @Override
    public boolean pureIsChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    @Override
    public boolean pureIsChild() {
        return super.isChild();
    }

    @Override
    public boolean pureIsDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public boolean pureIsFinishing() {
        return super.isFinishing();
    }

    @Override
    public boolean pureIsImmersive() {
        return super.isImmersive();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean pureIsInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean pureIsInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean pureIsLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }

    @Override
    public boolean pureIsTaskRoot() {
        return super.isTaskRoot();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean pureIsVoiceInteraction() {
        return super.isVoiceInteraction();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean pureIsVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }

    @Override
    public Cursor pureManagedQuery(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return super.managedQuery(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    public boolean pureMoveTaskToBack(boolean nonRoot) {
        return super.moveTaskToBack(nonRoot);
    }

    @Override
    public boolean pureNavigateUpTo(Intent upIntent) {
        return super.navigateUpTo(upIntent);
    }

    @Override
    public boolean pureNavigateUpToFromChild(Activity child, Intent upIntent) {
        return super.navigateUpToFromChild(child, upIntent);
    }

    @Override
    public void pureOnActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);
    }

    @Override
    public void pureOnActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);
    }

    @Override
    public void pureOnActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
    }

    @Override
    public void pureOnAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override
    public void pureOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    public void pureOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void pureOnConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void pureOnContentChanged() {
        super.onContentChanged();
    }

    @Override
    public boolean pureOnContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    public void pureOnContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override
    public void pureOnCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void pureOnCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public CharSequence pureOnCreateDescription() {
        return super.onCreateDescription();
    }

    @Override
    public void pureOnCreateNavigateUpTaskStack(TaskStackBuilder builder) {
        super.onCreateNavigateUpTaskStack(builder);
    }

    @Override
    public boolean pureOnCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean pureOnCreatePanelMenu(int featureId, Menu menu) {
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public View pureOnCreatePanelView(int featureId) {
        return super.onCreatePanelView(featureId);
    }

    @Override
    public boolean pureOnCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return super.onCreateThumbnail(outBitmap, canvas);
    }

    @Override
    public View pureOnCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    public View pureOnCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public void pureOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public void pureOnEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    @Override
    public boolean pureOnGenericMotionEvent(MotionEvent event) {
        return super.onGenericMotionEvent(event);
    }

    @TargetApi(Build.VERSION_CODES.Q)
    @Override
    public void pureOnGetDirectActions(CancellationSignal cancellationSignal, Consumer<List<DirectAction>> callback) {
        super.onGetDirectActions(cancellationSignal, callback);
    }

    @Override
    public boolean pureOnKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean pureOnKeyLongPress(int keyCode, KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean pureOnKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean pureOnKeyShortcut(int keyCode, KeyEvent event) {
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean pureOnKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureOnLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureOnLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    @Override
    public void pureOnLowMemory() {
        super.onLowMemory();
    }

    @Override
    public boolean pureOnMenuItemSelected(int featureId, MenuItem item) {
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public boolean pureOnMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureOnMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public void pureOnMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }

    @Override
    public boolean pureOnNavigateUp() {
        return super.onNavigateUp();
    }

    @Override
    public boolean pureOnNavigateUpFromChild(Activity child) {
        return super.onNavigateUpFromChild(child);
    }

    @Override
    public boolean pureOnOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void pureOnOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void pureOnPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
    }

    @TargetApi(Build.VERSION_CODES.Q)
    @Override
    public void pureOnPerformDirectAction(String actionId, Bundle arguments, CancellationSignal cancellationSignal, Consumer<Bundle> resultListener) {
        super.onPerformDirectAction(actionId, arguments, cancellationSignal, resultListener);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public void pureOnPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureOnPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public void pureOnPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public void pureOnPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
        super.onPrepareNavigateUpTaskStack(builder);
    }

    @Override
    public boolean pureOnPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean pureOnPreparePanel(int featureId, View view, Menu menu) {
        return super.onPreparePanel(featureId, view, menu);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void pureOnProvideAssistContent(AssistContent outContent) {
        super.onProvideAssistContent(outContent);
    }

    @Override
    public void pureOnProvideAssistData(Bundle data) {
        super.onProvideAssistData(data);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        super.onProvideKeyboardShortcuts(data, menu, deviceId);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public Uri pureOnProvideReferrer() {
        return super.onProvideReferrer();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void pureOnRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) throws IllegalArgumentException {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void pureOnRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public Object pureOnRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }

    @Override
    public void pureOnSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean pureOnSearchRequested(SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    @Override
    public boolean pureOnSearchRequested() {
        return super.onSearchRequested();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void pureOnStateNotSaved() {
        super.onStateNotSaved();
    }

    @TargetApi(Build.VERSION_CODES.Q)
    @Override
    public void pureOnTopResumedActivityChanged(boolean isTopResumedActivity) {
        super.onTopResumedActivityChanged(isTopResumedActivity);
    }

    @Override
    public boolean pureOnTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean pureOnTrackballEvent(MotionEvent event) {
        return super.onTrackballEvent(event);
    }

    @Override
    public void pureOnTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void pureOnUserInteraction() {
        super.onUserInteraction();
    }

    @Override
    public void pureOnVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    @Override
    public void pureOnWindowAttributesChanged(WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);
    }

    @Override
    public void pureOnWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public ActionMode pureOnWindowStartingActionMode(ActionMode.Callback callback, int type) {
        return super.onWindowStartingActionMode(callback, type);
    }

    @Override
    public ActionMode pureOnWindowStartingActionMode(ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    @Override
    public void pureOpenContextMenu(View view) {
        super.openContextMenu(view);
    }

    @Override
    public void pureOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    @Override
    public void pureOverridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    public void purePostponeEnterTransition() {
        super.postponeEnterTransition();
    }

    @Override
    public void pureRecreate() {
        super.recreate();
    }

    @TargetApi(Build.VERSION_CODES.Q)
    @Override
    public void pureRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }

    @Override
    public void pureRegisterForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override
    public boolean pureReleaseInstance() {
        return super.releaseInstance();
    }

    @Override
    public void pureRemoveDialog(int id) {
        super.removeDialog(id);
    }

    @Override
    public void pureReportFullyDrawn() {
        super.reportFullyDrawn();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public DragAndDropPermissions pureRequestDragAndDropPermissions(DragEvent event) {
        return requestDragAndDropPermissions(event);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void pureRequestPermissions(String[] permissions, int requestCode) {
        super.requestPermissions(permissions, requestCode);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureRequestShowKeyboardShortcuts() {
        super.requestShowKeyboardShortcuts();
    }

    @Override
    public boolean pureRequestVisibleBehind(boolean visible) {
        return super.requestVisibleBehind(visible);
    }

    @Override
    public boolean pureRequestWindowFeature(int featureId) {
        return super.requestWindowFeature(featureId);
    }

    @TargetApi(Build.VERSION_CODES.P)
    @Override
    public <T extends View> T pureRequireViewById(int id) {
        return super.requireViewById(id);
    }

    @Override
    public void pureRunOnUiThread(Runnable action) {
        super.runOnUiThread(action);
    }

    @Override
    public void pureSetActionBar(Toolbar toolbar) {
        super.setActionBar(toolbar);
    }

    @Override
    public void pureSetContentTransitionManager(TransitionManager tm) {
        super.setContentTransitionManager(tm);
    }

    @Override
    public void pureSetContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    @Override
    public void pureSetContentView(View view) {
        super.setContentView(view);
    }

    @Override
    public void pureSetContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void pureSetDefaultKeyMode(int mode) {
        super.setDefaultKeyMode(mode);
    }

    @Override
    public void pureSetEnterSharedElementCallback(SharedElementCallback callback) {
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void pureSetExitSharedElementCallback(SharedElementCallback callback) {
        super.setExitSharedElementCallback(callback);
    }

    @Override
    public void pureSetFeatureDrawable(int featureId, Drawable drawable) {
        super.setFeatureDrawable(featureId, drawable);
    }

    @Override
    public void pureSetFeatureDrawableAlpha(int featureId, int alpha) {
        super.setFeatureDrawableAlpha(featureId, alpha);
    }

    @Override
    public void pureSetFeatureDrawableResource(int featureId, int resId) {
        super.setFeatureDrawableResource(featureId, resId);
    }

    @Override
    public void pureSetFeatureDrawableUri(int featureId, Uri uri) {
        super.setFeatureDrawableUri(featureId, uri);
    }

    @Override
    public void pureSetFinishOnTouchOutside(boolean finish) {
        super.setFinishOnTouchOutside(finish);
    }

    @Override
    public void pureSetImmersive(boolean i) {
        super.setImmersive(i);
    }

    @TargetApi(Build.VERSION_CODES.Q)
    @Override
    public void pureSetInheritShowWhenLocked(boolean inheritShowWhenLocked) {
        super.setInheritShowWhenLocked(inheritShowWhenLocked);
    }

    @Override
    public void pureSetIntent(Intent newIntent) {
        super.setIntent(newIntent);
    }

    @Override
    public void pureSetMediaController(MediaController controller) {
        super.setMediaController(controller);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public void pureSetPictureInPictureParams(PictureInPictureParams params) {
        super.setPictureInPictureParams(params);
    }

    @Override
    public void pureSetProgress(int progress) {
        super.setProgress(progress);
    }

    @Override
    public void pureSetProgressBarIndeterminate(boolean indeterminate) {
        super.setProgressBarIndeterminate(indeterminate);
    }

    @Override
    public void pureSetProgressBarIndeterminateVisibility(boolean visible) {
        super.setProgressBarIndeterminateVisibility(visible);
    }

    @Override
    public void pureSetProgressBarVisibility(boolean visible) {
        super.setProgressBarVisibility(visible);
    }

    @Override
    public void pureSetRequestedOrientation(int requestedOrientation) {
        super.setRequestedOrientation(requestedOrientation);
    }

    @Override
    public void pureSetResult(int resultCode, Intent data) {
        super.setResult(resultCode, data);
    }

    @Override
    public void pureSetResult(int resultCode) {
        super.setResult(resultCode);
    }

    @Override
    public void pureSetSecondaryProgress(int secondaryProgress) {
        super.setSecondaryProgress(secondaryProgress);
    }

    @TargetApi(Build.VERSION_CODES.O_MR1)
    @Override
    public void pureSetShowWhenLocked(boolean showWhenLocked) {
        super.setShowWhenLocked(showWhenLocked);
    }

    @Override
    public void pureSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(taskDescription);
    }

    @Override
    public void pureSetTheme(int resid) {
        super.setTheme(resid);
    }

    @Override
    public void pureSetTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    public void pureSetTitle(int titleId) {
        super.setTitle(titleId);
    }

    @Override
    public void pureSetTitleColor(int textColor) {
        super.setTitleColor(textColor);
    }

    @TargetApi(Build.VERSION_CODES.O_MR1)
    @Override
    public void pureSetTurnScreenOn(boolean turnScreenOn) {
        super.setTurnScreenOn(turnScreenOn);
    }

    @Override
    public void pureSetVisible(boolean visible) {
        super.setVisible(visible);
    }

    @Override
    public void pureSetVolumeControlStream(int streamType) {
        super.setVolumeControlStream(streamType);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureSetVrModeEnabled(boolean enabled, ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        super.setVrModeEnabled(enabled, requestedComponent);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean pureShouldShowRequestPermissionRationale(String permission) {
        return super.shouldShowRequestPermissionRationale(permission);
    }

    @Override
    public boolean pureShouldUpRecreateTask(Intent targetIntent) {
        return super.shouldUpRecreateTask(targetIntent);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean pureShowAssist(Bundle args) {
        return super.showAssist(args);
    }

    @Override
    public boolean pureShowDialog(int id, Bundle args) {
        return super.showDialog(id, args);
    }

    @Override
    public void pureShowDialog(int id) {
        super.showDialog(id);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void pureShowLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public ActionMode pureStartActionMode(ActionMode.Callback callback, int type) {
        return super.startActionMode(callback, type);
    }

    @Override
    public ActionMode pureStartActionMode(ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    @Override
    public void pureStartActivities(Intent[] intents, Bundle options) throws ActivityNotFoundException {
        super.startActivities(intents, options);
    }

    @Override
    public void pureStartActivities(Intent[] intents) throws ActivityNotFoundException {
        super.startActivities(intents);
    }

    @Override
    public void pureStartActivity(Intent intent) throws ActivityNotFoundException {
        super.startActivity(intent);
    }

    @Override
    public void pureStartActivity(Intent intent, Bundle options) throws ActivityNotFoundException {
        super.startActivity(intent, options);
    }

    @Override
    public void pureStartActivityForResult(Intent intent, int requestCode) throws ActivityNotFoundException {
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void pureStartActivityForResult(Intent intent, int requestCode, Bundle options) throws ActivityNotFoundException {
        super.startActivityForResult(intent, requestCode, options);
    }

    @Override
    public void pureStartActivityFromChild(Activity child, Intent intent, int requestCode) throws ActivityNotFoundException {
        super.startActivityFromChild(child, intent, requestCode);
    }

    @Override
    public void pureStartActivityFromChild(Activity child, Intent intent, int requestCode, Bundle options) throws ActivityNotFoundException {
        super.startActivityFromChild(child, intent, requestCode, options);
    }

    @Override
    public void pureStartActivityFromFragment(Fragment fragment, Intent intent, int requestCode, Bundle options) throws ActivityNotFoundException {
        super.startActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void pureStartActivityFromFragment(Fragment fragment, Intent intent, int requestCode) throws ActivityNotFoundException {
        super.startActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public boolean pureStartActivityIfNeeded(Intent intent, int requestCode, Bundle options) {
        return super.startActivityIfNeeded(intent, requestCode, options);
    }

    @Override
    public boolean pureStartActivityIfNeeded(Intent intent, int requestCode) {
        return super.startActivityIfNeeded(intent, requestCode);
    }

    @Override
    public void pureStartIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void pureStartIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void pureStartIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void pureStartIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void pureStartIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void pureStartIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureStartLocalVoiceInteraction(Bundle privateOptions) {
        super.startLocalVoiceInteraction(privateOptions);
    }

    @Override
    public void pureStartLockTask() {
        super.startLockTask();
    }

    @Override
    public void pureStartManagingCursor(Cursor c) {
        super.startManagingCursor(c);
    }

    @Override
    public boolean pureStartNextMatchingActivity(Intent intent, Bundle options) {
        return super.startNextMatchingActivity(intent, options);
    }

    @Override
    public boolean pureStartNextMatchingActivity(Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    @Override
    public void pureStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }

    @Override
    public void pureStartSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, boolean globalSearch) {
        super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void pureStopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }

    @Override
    public void pureStopLockTask() {
        super.stopLockTask();
    }

    @Override
    public void pureStopManagingCursor(Cursor c) {
        super.stopManagingCursor(c);
    }

    @Override
    public void pureTakeKeyEvents(boolean get) {
        super.takeKeyEvents(get);
    }

    @Override
    public void pureTriggerSearch(String query, Bundle appSearchData) {
        super.triggerSearch(query, appSearchData);
    }

    @TargetApi(Build.VERSION_CODES.Q)
    @Override
    public void pureUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);
    }

    @Override
    public void pureUnregisterForContextMenu(View view) {
        super.unregisterForContextMenu(view);
    }

    @Override
    public void pureAttachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    public void pureOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void pureOnApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);
    }

    @Override
    public void pureOnChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
    }

    @Override
    public void pureOnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog pureOnCreateDialog(int id) {
        return super.onCreateDialog(id);
    }

    @Override
    public Dialog pureOnCreateDialog(int id, Bundle args) {
        return super.onCreateDialog(id, args);
    }

    @Override
    public void pureOnDestroy() {
        super.onDestroy();
    }

    @Override
    public void pureOnNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void pureOnPause() {
        super.onPause();
    }

    @Override
    public void pureOnPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void pureOnPostResume() {
        super.onPostResume();
    }

    @Override
    public void pureOnPrepareDialog(int id, Dialog dialog, Bundle args) {
        super.onPrepareDialog(id, dialog, args);
    }

    @Override
    public void pureOnPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
    }

    @Override
    public void pureOnRestart() {
        super.onRestart();
    }

    @Override
    public void pureOnRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void pureOnResume() {
        super.onResume();
    }

    @Override
    public void pureOnSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void pureOnStart() {
        super.onStart();
    }

    @Override
    public void pureOnStop() {
        super.onStop();
    }

    @Override
    public void pureOnTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }

    @Override
    public void pureOnUserLeaveHint() {
        super.onUserLeaveHint();
    }
}
