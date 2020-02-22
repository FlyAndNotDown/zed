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
