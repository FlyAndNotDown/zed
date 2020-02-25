package pers.kindem.zed.runtime.container.activity;

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

import pers.kindem.zed.runtime.container.context.PluginContextThemeWrapper;

public class BasePluginActivity extends PluginContextThemeWrapper implements PluginActivityDefined {
    protected ContainerActivityCallback containerActivityCallback;

    public BasePluginActivity() {
        super(null);
    }

    public BasePluginActivity(Context context) {
        super(context);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        containerActivityCallback.pureAddContentView(view, params);
    }

    @Override
    public void closeContextMenu() {
        containerActivityCallback.pureCloseContextMenu();
    }

    @Override
    public void closeOptionsMenu() {
        containerActivityCallback.pureCloseOptionsMenu();
    }

    @Override
    public PendingIntent createPendingResult(int requestCode, Intent data, int flags) {
        return containerActivityCallback.pureCreatePendingResult(requestCode, data, flags);
    }

    @Override
    public void dismissDialog(int id) throws IllegalArgumentException {
        containerActivityCallback.pureDismissDialog(id);
    }

    @Override
    public void dismissKeyboardShortcutsHelper() {
        containerActivityCallback.pureDismissKeyboardShortcutsHelper();
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        return containerActivityCallback.pureDispatchGenericMotionEvent(ev);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return containerActivityCallback.pureDispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return containerActivityCallback.pureDispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return containerActivityCallback.pureDispatchPopulateAccessibilityEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return containerActivityCallback.pureDispatchTouchEvent(ev);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        return containerActivityCallback.pureDispatchTrackballEvent(ev);
    }

    @Override
    public boolean enterPictureInPictureMode(PictureInPictureParams params) {
        return containerActivityCallback.pureEnterPictureInPictureMode(params);
    }

    @Override
    public void enterPictureInPictureMode() {
        containerActivityCallback.pureEnterPictureInPictureMode();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return containerActivityCallback.pureFindViewById(id);
    }

    @Override
    public void finish() {
        containerActivityCallback.pureFinish();
    }

    @Override
    public void finishActivity(int requestCode) {
        containerActivityCallback.pureFinishActivity(requestCode);
    }

    @Override
    public void finishActivityFromChild(Activity child, int requestCode) {
        containerActivityCallback.pureFinishActivityFromChild(child, requestCode);
    }

    @Override
    public void finishAffinity() {
        containerActivityCallback.pureFinishAffinity();
    }

    @Override
    public void finishAfterTransition() {
        containerActivityCallback.pureFinishAfterTransition();
    }

    @Override
    public void finishAndRemoveTask() {
        containerActivityCallback.pureFinishAndRemoveTask();
    }

    @Override
    public void finishFromChild(Activity child) {
        containerActivityCallback.pureFinishFromChild(child);
    }

    @Override
    public ActionBar getActionBar() {
        return containerActivityCallback.pureGetActionBar();
    }

    @Override
    public Application getApplication() {
        return containerActivityCallback.pureGetApplication();
    }

    @Override
    public ComponentName getCallingActivity() {
        return containerActivityCallback.pureGetCallingActivity();
    }

    @Override
    public String getCallingPackage() {
        return containerActivityCallback.pureGetCallingPackage();
    }

    @Override
    public int getChangingConfigurations() {
        return containerActivityCallback.pureGetChangingConfigurations();
    }

    @Override
    public ComponentName getComponentName() {
        return containerActivityCallback.pureGetComponentName();
    }

    @Override
    public Scene getContentScene() {
        return containerActivityCallback.pureGetContentScene();
    }

    @Override
    public TransitionManager getContentTransitionManager() {
        return containerActivityCallback.pureGetContentTransitionManager();
    }

    @Override
    public View getCurrentFocus() {
        return containerActivityCallback.pureGetCurrentFocus();
    }

    @Override
    public FragmentManager getFragmentManager() {
        return containerActivityCallback.pureGetFragmentManager();
    }

    @Override
    public Intent getIntent() {
        return containerActivityCallback.pureGetIntent();
    }

    @Override
    public Object getLastNonConfigurationInstance() {
        return containerActivityCallback.pureGetLastNonConfigurationInstance();
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return containerActivityCallback.pureGetLayoutInflater();
    }

    @Override
    public LoaderManager getLoaderManager() {
        return containerActivityCallback.pureGetLoaderManager();
    }

    @Override
    public String getLocalClassName() {
        return containerActivityCallback.pureGetLocalClassName();
    }

    @Override
    public int getMaxNumPictureInPictureActions() {
        return containerActivityCallback.pureGetMaxNumPictureInPictureActions();
    }

    @Override
    public MediaController getMediaController() {
        return containerActivityCallback.pureGetMediaController();
    }

    @Override
    public MenuInflater getMenuInflater() {
        return containerActivityCallback.pureGetMenuInflater();
    }

    @Override
    public Activity getParent() {
        return containerActivityCallback.pureGetParent();
    }

    @Override
    public Intent getParentActivityIntent() {
        return containerActivityCallback.pureGetParentActivityIntent();
    }

    @Override
    public SharedPreferences getPreferences(int mde) {
        return containerActivityCallback.pureGetPreferences(mde);
    }

    @Override
    public Uri getReferrer() {
        return containerActivityCallback.pureGetReferrer();
    }

    @Override
    public int getRequestedOrientation() {
        return containerActivityCallback.pureGetRequestedOrientation();
    }

    @Override
    public SearchEvent getSearchEvent() {
        return containerActivityCallback.pureGetSearchEvent();
    }

    @Override
    public Object getSystemService(String name) {
        return containerActivityCallback.pureGetSystemService(name);
    }

    @Override
    public int getTaskId() {
        return containerActivityCallback.pureGetTaskId();
    }

    @Override
    public CharSequence getTitle() {
        return containerActivityCallback.pureGetTitle();
    }

    @Override
    public int getTitleColor() {
        return containerActivityCallback.pureGetTitleColor();
    }

    @Override
    public VoiceInteractor getVoiceInteractor() {
        return containerActivityCallback.pureGetVoiceInteractor();
    }

    @Override
    public int getVolumeControlStream() {
        return containerActivityCallback.pureGetVolumeControlStream();
    }

    @Override
    public Window getWindow() {
        return containerActivityCallback.pureGetWindow();
    }

    @Override
    public WindowManager getWindowManager() {
        return containerActivityCallback.pureGetWindowManager();
    }

    @Override
    public boolean hasWindowFocus() {
        return containerActivityCallback.pureHasWindowFocus();
    }

    @Override
    public void invalidateOptionsMenu() {
        containerActivityCallback.pureInvalidateOptionsMenu();
    }

    @Override
    public boolean isActivityTransitionRunning() {
        return containerActivityCallback.pureIsActivityTransitionRunning();
    }

    @Override
    public boolean isChangingConfigurations() {
        return containerActivityCallback.pureIsChangingConfigurations();
    }

    @Override
    public boolean isChild() {
        return containerActivityCallback.pureIsChild();
    }

    @Override
    public boolean isDestroyed() {
        return containerActivityCallback.pureIsDestroyed();
    }

    @Override
    public boolean isFinishing() {
        return containerActivityCallback.pureIsFinishing();
    }

    @Override
    public boolean isImmersive() {
        return containerActivityCallback.pureIsImmersive();
    }

    @Override
    public boolean isInMultiWindowMode() {
        return containerActivityCallback.pureIsInMultiWindowMode();
    }

    @Override
    public boolean isInPictureInPictureMode() {
        return containerActivityCallback.pureIsInPictureInPictureMode();
    }

    @Override
    public boolean isLocalVoiceInteractionSupported() {
        return containerActivityCallback.pureIsLocalVoiceInteractionSupported();
    }

    @Override
    public boolean isTaskRoot() {
        return containerActivityCallback.pureIsTaskRoot();
    }

    @Override
    public boolean isVoiceInteraction() {
        return containerActivityCallback.pureIsVoiceInteraction();
    }

    @Override
    public boolean isVoiceInteractionRoot() {
        return containerActivityCallback.pureIsVoiceInteractionRoot();
    }

    @Override
    public Cursor managedQuery(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return containerActivityCallback.pureManagedQuery(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        return containerActivityCallback.pureMoveTaskToBack(nonRoot);
    }

    @Override
    public boolean navigateUpTo(Intent upIntent) {
        return containerActivityCallback.pureNavigateUpTo(upIntent);
    }

    @Override
    public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        return containerActivityCallback.pureNavigateUpToFromChild(child, upIntent);
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        containerActivityCallback.pureOnActionModeFinished(mode);
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        containerActivityCallback.pureOnActionModeStarted(mode);
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        containerActivityCallback.pureOnActivityReenter(resultCode, data);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        containerActivityCallback.pureOnAttachFragment(fragment);
    }

    @Override
    public void onAttachedToWindow() {
        containerActivityCallback.pureOnAttachedToWindow();
    }

    @Override
    public void onBackPressed() {
        containerActivityCallback.pureOnBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        containerActivityCallback.pureOnConfigurationChanged(newConfig);
    }

    @Override
    public void onContentChanged() {
        containerActivityCallback.pureOnContentChanged();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return containerActivityCallback.pureOnContextItemSelected(item);
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        containerActivityCallback.pureOnContextMenuClosed(menu);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        containerActivityCallback.pureOnCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        containerActivityCallback.pureOnCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public CharSequence onCreateDescription() {
        return containerActivityCallback.pureOnCreateDescription();
    }

    @Override
    public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
        containerActivityCallback.pureOnCreateNavigateUpTaskStack(builder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return containerActivityCallback.pureOnCreateOptionsMenu(menu);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return containerActivityCallback.pureOnCreatePanelMenu(featureId, menu);
    }

    @Override
    public View onCreatePanelView(int featureId) {
        return containerActivityCallback.pureOnCreatePanelView(featureId);
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return containerActivityCallback.pureOnCreateThumbnail(outBitmap, canvas);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return containerActivityCallback.pureOnCreateView(parent, name, context, attrs);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return containerActivityCallback.pureOnCreateView(name, context, attrs);
    }

    @Override
    public void onDetachedFromWindow() {
        containerActivityCallback.pureOnDetachedFromWindow();
    }

    @Override
    public void onEnterAnimationComplete() {
        containerActivityCallback.pureOnEnterAnimationComplete();
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return containerActivityCallback.pureOnGenericMotionEvent(event);
    }

    @Override
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer<List<DirectAction>> callback) {
        containerActivityCallback.pureOnGetDirectActions(cancellationSignal, callback);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return containerActivityCallback.pureOnKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return containerActivityCallback.pureOnKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return containerActivityCallback.pureOnKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return containerActivityCallback.pureOnKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return containerActivityCallback.pureOnKeyUp(keyCode, event);
    }

    @Override
    public void onLocalVoiceInteractionStarted() {
        containerActivityCallback.pureOnLocalVoiceInteractionStarted();
    }

    @Override
    public void onLocalVoiceInteractionStopped() {
        containerActivityCallback.pureOnLocalVoiceInteractionStopped();
    }

    @Override
    public void onLowMemory() {
        containerActivityCallback.pureOnLowMemory();
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return containerActivityCallback.pureOnMenuItemSelected(featureId, item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return containerActivityCallback.pureOnMenuOpened(featureId, menu);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        containerActivityCallback.pureOnMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        containerActivityCallback.pureOnMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }

    @Override
    public boolean onNavigateUp() {
        return containerActivityCallback.pureOnNavigateUp();
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        return containerActivityCallback.pureOnNavigateUpFromChild(child);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return containerActivityCallback.pureOnOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        containerActivityCallback.pureOnOptionsMenuClosed(menu);
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        containerActivityCallback.pureOnPanelClosed(featureId, menu);
    }

    @Override
    public void onPerformDirectAction(String actionId, Bundle arguments, CancellationSignal cancellationSignal, Consumer<Bundle> resultListener) {
        containerActivityCallback.pureOnPerformDirectAction(actionId, arguments, cancellationSignal, resultListener);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        containerActivityCallback.pureOnPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        containerActivityCallback.pureOnPictureInPictureModeChanged(isInPictureInPictureMode);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        containerActivityCallback.pureOnPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
        containerActivityCallback.pureOnPrepareNavigateUpTaskStack(builder);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return containerActivityCallback.pureOnPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return containerActivityCallback.pureOnPreparePanel(featureId, view, menu);
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        containerActivityCallback.pureOnProvideAssistContent(outContent);
    }

    @Override
    public void onProvideAssistData(Bundle data) {
        containerActivityCallback.pureOnProvideAssistData(data);
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
        containerActivityCallback.pureOnProvideKeyboardShortcuts(data, menu, deviceId);
    }

    @Override
    public Uri onProvideReferrer() {
        return containerActivityCallback.pureOnProvideReferrer();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) throws IllegalArgumentException {
        containerActivityCallback.pureOnRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        containerActivityCallback.pureOnRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        return containerActivityCallback.pureOnRetainNonConfigurationInstance();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        containerActivityCallback.pureOnSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return containerActivityCallback.pureOnSearchRequested(searchEvent);
    }

    @Override
    public boolean onSearchRequested() {
        return containerActivityCallback.pureOnSearchRequested();
    }

    @Override
    public void onStateNotSaved() {
        containerActivityCallback.pureOnStateNotSaved();
    }

    @Override
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        containerActivityCallback.pureOnTopResumedActivityChanged(isTopResumedActivity);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return containerActivityCallback.pureOnTouchEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        return containerActivityCallback.pureOnTrackballEvent(event);
    }

    @Override
    public void onTrimMemory(int level) {
        containerActivityCallback.pureOnTrimMemory(level);
    }

    @Override
    public void onUserInteraction() {
        containerActivityCallback.pureOnUserInteraction();
    }

    @Override
    public void onVisibleBehindCanceled() {
        containerActivityCallback.pureOnVisibleBehindCanceled();
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        containerActivityCallback.pureOnWindowAttributesChanged(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        containerActivityCallback.pureOnWindowFocusChanged(hasFocus);
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
        return containerActivityCallback.pureOnWindowStartingActionMode(callback, type);
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return containerActivityCallback.pureOnWindowStartingActionMode(callback);
    }

    @Override
    public void openContextMenu(View view) {
        containerActivityCallback.pureOpenContextMenu(view);
    }

    @Override
    public void openOptionsMenu() {
        containerActivityCallback.pureOpenOptionsMenu();
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        containerActivityCallback.pureOverridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    public void postponeEnterTransition() {
        containerActivityCallback.purePostponeEnterTransition();
    }

    @Override
    public void recreate() {
        containerActivityCallback.pureRecreate();
    }

    @Override
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        containerActivityCallback.pureRegisterActivityLifecycleCallbacks(callback);
    }

    @Override
    public void registerForContextMenu(View view) {
        containerActivityCallback.pureRegisterForContextMenu(view);
    }

    @Override
    public boolean releaseInstance() {
        return containerActivityCallback.pureReleaseInstance();
    }

    @Override
    public void removeDialog(int id) {
        containerActivityCallback.pureRemoveDialog(id);
    }

    @Override
    public void reportFullyDrawn() {
        containerActivityCallback.pureReportFullyDrawn();
    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        return containerActivityCallback.pureRequestDragAndDropPermissions(event);
    }

    @Override
    public void requestPermissions(String[] permissions, int requestCode) {
        containerActivityCallback.pureRequestPermissions(permissions, requestCode);
    }

    @Override
    public void requestShowKeyboardShortcuts() {
        containerActivityCallback.pureRequestShowKeyboardShortcuts();
    }

    @Override
    public boolean requestVisibleBehind(boolean visible) {
        return containerActivityCallback.pureRequestVisibleBehind(visible);
    }

    @Override
    public boolean requestWindowFeature(int featureId) {
        return containerActivityCallback.pureRequestWindowFeature(featureId);
    }

    @Override
    public <T extends View> T requireViewById(int id) {
        return containerActivityCallback.pureRequireViewById(id);
    }

    @Override
    public void runOnUiThread(Runnable action) {
        containerActivityCallback.pureRunOnUiThread(action);
    }

    @Override
    public void setActionBar(Toolbar toolbar) {
        containerActivityCallback.pureSetActionBar(toolbar);
    }

    @Override
    public void setContentTransitionManager(TransitionManager tm) {
        containerActivityCallback.pureSetContentTransitionManager(tm);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        containerActivityCallback.pureSetContentView(view, params);
    }

    @Override
    public void setContentView(View view) {
        containerActivityCallback.pureSetContentView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        containerActivityCallback.pureSetContentView(layoutResID);
    }

    @Override
    public void setDefaultKeyMode(int mode) {
        containerActivityCallback.pureSetDefaultKeyMode(mode);
    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        containerActivityCallback.pureSetEnterSharedElementCallback(callback);
    }

    @Override
    public void setExitSharedElementCallback(SharedElementCallback callback) {
        containerActivityCallback.pureSetExitSharedElementCallback(callback);
    }

    @Override
    public void setFeatureDrawable(int featureId, Drawable drawable) {
        containerActivityCallback.pureSetFeatureDrawable(featureId, drawable);
    }

    @Override
    public void setFeatureDrawableAlpha(int featureId, int alpha) {
        containerActivityCallback.pureSetFeatureDrawableAlpha(featureId, alpha);
    }

    @Override
    public void setFeatureDrawableResource(int featureId, int resId) {
        containerActivityCallback.pureSetFeatureDrawableResource(featureId, resId);
    }

    @Override
    public void setFeatureDrawableUri(int featureId, Uri uri) {
        containerActivityCallback.pureSetFeatureDrawableUri(featureId, uri);
    }

    @Override
    public void setFinishOnTouchOutside(boolean finish) {
        containerActivityCallback.pureSetFinishOnTouchOutside(finish);
    }

    @Override
    public void setImmersive(boolean i) {
        containerActivityCallback.pureSetImmersive(i);
    }

    @Override
    public void setInheritShowWhenLocked(boolean inheritShowWhenLocked) {
        containerActivityCallback.pureSetInheritShowWhenLocked(inheritShowWhenLocked);
    }

    @Override
    public void setIntent(Intent newIntent) {
        containerActivityCallback.pureSetIntent(newIntent);
    }

    @Override
    public void setMediaController(MediaController controller) {
        containerActivityCallback.pureSetMediaController(controller);
    }

    @Override
    public void setPictureInPictureParams(PictureInPictureParams params) {
        containerActivityCallback.pureSetPictureInPictureParams(params);
    }

    @Override
    public void setProgress(int progress) {
        containerActivityCallback.pureSetProgress(progress);
    }

    @Override
    public void setProgressBarIndeterminate(boolean indeterminate) {
        containerActivityCallback.pureSetProgressBarIndeterminate(indeterminate);
    }

    @Override
    public void setProgressBarIndeterminateVisibility(boolean visible) {
        containerActivityCallback.pureSetProgressBarIndeterminateVisibility(visible);
    }

    @Override
    public void setProgressBarVisibility(boolean visible) {
        containerActivityCallback.pureSetProgressBarVisibility(visible);
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        containerActivityCallback.pureSetRequestedOrientation(requestedOrientation);
    }

    @Override
    public void setResult(int resultCode, Intent data) {
        containerActivityCallback.pureSetResult(resultCode, data);
    }

    @Override
    public void setResult(int resultCode) {
        containerActivityCallback.pureSetResult(resultCode);
    }

    @Override
    public void setSecondaryProgress(int secondaryProgress) {
        containerActivityCallback.pureSetSecondaryProgress(secondaryProgress);
    }

    @Override
    public void setShowWhenLocked(boolean showWhenLocked) {
        containerActivityCallback.pureSetShowWhenLocked(showWhenLocked);
    }

    @Override
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        containerActivityCallback.pureSetTaskDescription(taskDescription);
    }

    @Override
    public void setTitle(CharSequence title) {
        containerActivityCallback.pureSetTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        containerActivityCallback.pureSetTitle(titleId);
    }

    @Override
    public void setTitleColor(int textColor) {
        containerActivityCallback.pureSetTitleColor(textColor);
    }

    @Override
    public void setTurnScreenOn(boolean turnScreenOn) {
        containerActivityCallback.pureSetTurnScreenOn(turnScreenOn);
    }

    @Override
    public void setVisible(boolean visible) {
        containerActivityCallback.pureSetVisible(visible);
    }

    @Override
    public void setVolumeControlStream(int streamType) {
        containerActivityCallback.pureSetVolumeControlStream(streamType);
    }

    @Override
    public void setVrModeEnabled(boolean enabled, ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
        containerActivityCallback.pureSetVrModeEnabled(enabled, requestedComponent);
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(String permission) {
        return containerActivityCallback.pureShouldShowRequestPermissionRationale(permission);
    }

    @Override
    public boolean shouldUpRecreateTask(Intent targetIntent) {
        return containerActivityCallback.pureShouldUpRecreateTask(targetIntent);
    }

    @Override
    public boolean showAssist(Bundle args) {
        return containerActivityCallback.pureShowAssist(args);
    }

    @Override
    public boolean showDialog(int id, Bundle args) {
        return containerActivityCallback.pureShowDialog(id, args);
    }

    @Override
    public void showDialog(int id) {
        containerActivityCallback.pureShowDialog(id);
    }

    @Override
    public void showLockTaskEscapeMessage() {
        containerActivityCallback.pureShowLockTaskEscapeMessage();
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        return containerActivityCallback.pureStartActionMode(callback, type);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return containerActivityCallback.pureStartActionMode(callback);
    }

    @Override
    public void startActivities(Intent[] intents) {
        containerActivityCallback.pureStartActivities(intents);
    }

    @Override
    public void startActivities(Intent[] intents, Bundle options) {
        containerActivityCallback.pureStartActivities(intents, options);
    }

    @Override
    public void startActivity(Intent intent) {
        containerActivityCallback.pureStartActivity(intent);
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        containerActivityCallback.pureStartActivity(intent, options);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) throws ActivityNotFoundException {
        containerActivityCallback.pureStartActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) throws ActivityNotFoundException {
        containerActivityCallback.pureStartActivityForResult(intent, requestCode, options);
    }

    @Override
    public void startActivityFromChild(Activity child, Intent intent, int requestCode) throws ActivityNotFoundException {
        containerActivityCallback.pureStartActivityFromChild(child, intent, requestCode);
    }

    @Override
    public void startActivityFromChild(Activity child, Intent intent, int requestCode, Bundle options) throws ActivityNotFoundException {
        containerActivityCallback.pureStartActivityFromChild(child, intent, requestCode, options);
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, Bundle options) throws ActivityNotFoundException {
        containerActivityCallback.pureStartActivityFromFragment(fragment, intent, requestCode, options);
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) throws ActivityNotFoundException {
        containerActivityCallback.pureStartActivityFromFragment(fragment, intent, requestCode);
    }

    @Override
    public boolean startActivityIfNeeded(Intent intent, int requestCode, Bundle options) {
        return containerActivityCallback.pureStartActivityIfNeeded(intent, requestCode, options);
    }

    @Override
    public boolean startActivityIfNeeded(Intent intent, int requestCode) {
        return containerActivityCallback.pureStartActivityIfNeeded(intent, requestCode);
    }

    @Override
    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        containerActivityCallback.pureStartIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        containerActivityCallback.pureStartIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        containerActivityCallback.pureStartIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        containerActivityCallback.pureStartIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        containerActivityCallback.pureStartIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        containerActivityCallback.pureStartIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Override
    public void startLocalVoiceInteraction(Bundle privateOptions) {
        containerActivityCallback.pureStartLocalVoiceInteraction(privateOptions);
    }

    @Override
    public void startLockTask() {
        containerActivityCallback.pureStartLockTask();
    }

    @Override
    public void startManagingCursor(Cursor c) {
        containerActivityCallback.pureStartManagingCursor(c);
    }

    @Override
    public boolean startNextMatchingActivity(Intent intent, Bundle options) {
        return containerActivityCallback.pureStartNextMatchingActivity(intent, options);
    }

    @Override
    public boolean startNextMatchingActivity(Intent intent) {
        return containerActivityCallback.pureStartNextMatchingActivity(intent);
    }

    @Override
    public void startPostponedEnterTransition() {
        containerActivityCallback.pureStartPostponedEnterTransition();
    }

    @Override
    public void startSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, boolean globalSearch) {
        containerActivityCallback.pureStartSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
    }

    @Override
    public void stopLocalVoiceInteraction() {
        containerActivityCallback.pureStopLocalVoiceInteraction();
    }

    @Override
    public void stopLockTask() {
        containerActivityCallback.pureStopLockTask();
    }

    @Override
    public void stopManagingCursor(Cursor c) {
        containerActivityCallback.pureStopManagingCursor(c);
    }

    @Override
    public void takeKeyEvents(boolean get) {
        containerActivityCallback.pureTakeKeyEvents(get);
    }

    @Override
    public void triggerSearch(String query, Bundle appSearchData) {
        containerActivityCallback.pureTriggerSearch(query, appSearchData);
    }

    @Override
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        containerActivityCallback.pureUnregisterActivityLifecycleCallbacks(callback);
    }

    @Override
    public void unregisterForContextMenu(View view) {
        containerActivityCallback.pureUnregisterForContextMenu(view);
    }

    @Override
    public void attachBaseContext(Context newBase) {
        containerActivityCallback.pureAttachBaseContext(newBase);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        containerActivityCallback.pureOnActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        containerActivityCallback.pureOnApplyThemeResource(theme, resid, first);
    }

    @Override
    public void onChildTitleChanged(Activity childActivity, CharSequence title) {
        containerActivityCallback.pureOnChildTitleChanged(childActivity, title);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        containerActivityCallback.pureOnCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(int id) {
        return containerActivityCallback.pureOnCreateDialog(id);
    }

    @Override
    public Dialog onCreateDialog(int id, Bundle args) {
        return containerActivityCallback.pureOnCreateDialog(id, args);
    }

    @Override
    public void onDestroy() {
        containerActivityCallback.pureOnDestroy();
    }

    @Override
    public void onNewIntent(Intent intent) {
        containerActivityCallback.pureOnNewIntent(intent);
    }

    @Override
    public void onPause() {
        containerActivityCallback.pureOnPause();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        containerActivityCallback.pureOnPostCreate(savedInstanceState);
    }

    @Override
    public void onPostResume() {
        containerActivityCallback.pureOnPostResume();
    }

    @Override
    public void onPrepareDialog(int id, Dialog dialog, Bundle args) {
        containerActivityCallback.pureOnPrepareDialog(id, dialog, args);
    }

    @Override
    public void onPrepareDialog(int id, Dialog dialog) {
        containerActivityCallback.pureOnPrepareDialog(id, dialog);
    }

    @Override
    public void onRestart() {
        containerActivityCallback.pureOnRestart();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        containerActivityCallback.pureOnRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onResume() {
        containerActivityCallback.pureOnResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        containerActivityCallback.pureOnSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        containerActivityCallback.pureOnStart();
    }

    @Override
    public void onStop() {
        containerActivityCallback.pureOnStop();
    }

    @Override
    public void onTitleChanged(CharSequence title, int color) {
        containerActivityCallback.pureOnTitleChanged(title, color);
    }

    @Override
    public void onUserLeaveHint() {
        containerActivityCallback.pureOnUserLeaveHint();
    }
}
