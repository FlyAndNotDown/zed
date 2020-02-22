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

    }

    @Override
    public void closeContextMenu() {

    }

    @Override
    public void closeOptionsMenu() {

    }

    @Override
    public PendingIntent createPendingResult(int requestCode, Intent data, int flags) {
        return null;
    }

    @Override
    public void dismissDialog(int id) throws IllegalArgumentException {

    }

    @Override
    public void dismissKeyboardShortcutsHelper() {

    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return false;
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return false;
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean enterPictureInPictureMode(PictureInPictureParams params) {
        return false;
    }

    @Override
    public void enterPictureInPictureMode() {

    }

    @Override
    public <T extends View> T findViewById(int id) {
        return null;
    }

    @Override
    public void finish() {

    }

    @Override
    public void finishActivity(int requestCode) {

    }

    @Override
    public void finishActivityFromChild(Activity child, int requestCode) {

    }

    @Override
    public void finishAffinity() {

    }

    @Override
    public void finishAfterTransition() {

    }

    @Override
    public void finishAndRemoveTask() {

    }

    @Override
    public void finishFromChild(Activity child) {

    }

    @Override
    public ActionBar getActionBar() {
        return null;
    }

    @Override
    public Application getApplication() {
        return null;
    }

    @Override
    public ComponentName getCallingActivity() {
        return null;
    }

    @Override
    public String getCallingPackage() {
        return null;
    }

    @Override
    public int getChangingConfigurations() {
        return 0;
    }

    @Override
    public ComponentName getComponentName() {
        return null;
    }

    @Override
    public Scene getContentScene() {
        return null;
    }

    @Override
    public TransitionManager getContentTransitionManager() {
        return null;
    }

    @Override
    public View getCurrentFocus() {
        return null;
    }

    @Override
    public FragmentManager getFragmentManager() {
        return null;
    }

    @Override
    public Intent getIntent() {
        return null;
    }

    @Override
    public Object getLastNonConfigurationInstance() {
        return null;
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        return null;
    }

    @Override
    public LoaderManager getLoaderManager() {
        return null;
    }

    @Override
    public String getLocalClassName() {
        return null;
    }

    @Override
    public int getMaxNumPictureInPictureActions() {
        return 0;
    }

    @Override
    public MediaController getMediaController() {
        return null;
    }

    @Override
    public MenuInflater getMenuInflater() {
        return null;
    }

    @Override
    public Activity getParent() {
        return null;
    }

    @Override
    public Intent getParentActivityIntent() {
        return null;
    }

    @Override
    public SharedPreferences getPreferences(int mde) {
        return null;
    }

    @Override
    public Uri getReferrer() {
        return null;
    }

    @Override
    public int getRequestedOrientation() {
        return 0;
    }

    @Override
    public SearchEvent getSearchEvent() {
        return null;
    }

    @Override
    public int getTaskId() {
        return 0;
    }

    @Override
    public CharSequence getTitle() {
        return null;
    }

    @Override
    public int getTitleColor() {
        return 0;
    }

    @Override
    public VoiceInteractor getVoiceInteractor() {
        return null;
    }

    @Override
    public int getVolumeControlStream() {
        return 0;
    }

    @Override
    public Window getWindow() {
        return null;
    }

    @Override
    public WindowManager getWindowManager() {
        return null;
    }

    @Override
    public boolean hasWindowFocus() {
        return false;
    }

    @Override
    public void invalidateOptionsMenu() {

    }

    @Override
    public boolean isActivityTransitionRunning() {
        return false;
    }

    @Override
    public boolean isChangingConfigurations() {
        return false;
    }

    @Override
    public boolean isChild() {
        return false;
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isFinishing() {
        return false;
    }

    @Override
    public boolean isImmersive() {
        return false;
    }

    @Override
    public boolean isInMultiWindowMode() {
        return false;
    }

    @Override
    public boolean isInPictureInPictureMode() {
        return false;
    }

    @Override
    public boolean isLocalVoiceInteractionSupported() {
        return false;
    }

    @Override
    public boolean isTaskRoot() {
        return false;
    }

    @Override
    public boolean isVoiceInteraction() {
        return false;
    }

    @Override
    public boolean isVoiceInteractionRoot() {
        return false;
    }

    @Override
    public Cursor managedQuery(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public boolean moveTaskToBack(boolean nonRoot) {
        return false;
    }

    @Override
    public boolean navigateUpTo(Intent upIntent) {
        return false;
    }

    @Override
    public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
        return false;
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {

    }

    @Override
    public void onActionModeStarted(ActionMode mode) {

    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {

    }

    @Override
    public void onAttachFragment(Fragment fragment) {

    }

    @Override
    public void onAttachedToWindow() {

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onContentChanged() {

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onContextMenuClosed(Menu menu) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }

    @Override
    public CharSequence onCreateDescription() {
        return null;
    }

    @Override
    public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return false;
    }

    @Override
    public View onCreatePanelView(int featureId) {
        return null;
    }

    @Override
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        return false;
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return null;
    }

    @Override
    public void onDetachedFromWindow() {

    }

    @Override
    public void onEnterAnimationComplete() {

    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return false;
    }

    @Override
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer<List<DirectAction>> callback) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public void onLocalVoiceInteractionStarted() {

    }

    @Override
    public void onLocalVoiceInteractionStopped() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return false;
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {

    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {

    }

    @Override
    public boolean onNavigateUp() {
        return false;
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {

    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {

    }

    @Override
    public void onPerformDirectAction(String actionId, Bundle arguments, CancellationSignal cancellationSignal, Consumer<Bundle> resultListener) {

    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {

    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return false;
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {

    }

    @Override
    public void onProvideAssistData(Bundle data) {

    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {

    }

    @Override
    public Uri onProvideReferrer() {
        return null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) throws IllegalArgumentException {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {

    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        return null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

    }

    @Override
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return false;
    }

    @Override
    public boolean onSearchRequested() {
        return false;
    }

    @Override
    public void onStateNotSaved() {

    }

    @Override
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        return false;
    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void onUserInteraction() {

    }

    @Override
    public void onVisibleBehindCanceled() {

    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
        return null;
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override
    public void openContextMenu(View view) {

    }

    @Override
    public void openOptionsMenu() {

    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {

    }

    @Override
    public void postponeEnterTransition() {

    }

    @Override
    public void recreate() {

    }

    @Override
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {

    }

    @Override
    public void registerForContextMenu(View view) {

    }

    @Override
    public boolean releaseInstance() {
        return false;
    }

    @Override
    public void removeDialog(int id) {

    }

    @Override
    public void reportFullyDrawn() {

    }

    @Override
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
        return null;
    }

    @Override
    public void requestPermissions(String[] permissions, int requestCode) {

    }

    @Override
    public void requestShowKeyboardShortcuts() {

    }

    @Override
    public boolean requestVisibleBehind(boolean visible) {
        return false;
    }

    @Override
    public boolean requestWindowFeature(int featureId) {
        return false;
    }

    @Override
    public <T extends View> T requireViewById(int id) {
        return null;
    }

    @Override
    public void runOnUiThread(Runnable action) {

    }

    @Override
    public void setActionBar(Toolbar toolbar) {

    }

    @Override
    public void setContentTransitionManager(TransitionManager tm) {

    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {

    }

    @Override
    public void setContentView(View view) {

    }

    @Override
    public void setContentView(int layoutResID) {

    }

    @Override
    public void setDefaultKeyMode(int mode) {

    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {

    }

    @Override
    public void setExitSharedElementCallback(SharedElementCallback callback) {

    }

    @Override
    public void setFeatureDrawable(int featureId, Drawable drawable) {

    }

    @Override
    public void setFeatureDrawableAlpha(int featureId, int alpha) {

    }

    @Override
    public void setFeatureDrawableResource(int featureId, int resId) {

    }

    @Override
    public void setFeatureDrawableUri(int featureId, Uri uri) {

    }

    @Override
    public void setFinishOnTouchOutside(boolean finish) {

    }

    @Override
    public void setImmersive(boolean i) {

    }

    @Override
    public void setInheritShowWhenLocked(boolean inheritShowWhenLocked) {

    }

    @Override
    public void setIntent(Intent newIntent) {

    }

    @Override
    public void setMediaController(MediaController controller) {

    }

    @Override
    public void setPictureInPictureParams(PictureInPictureParams params) {

    }

    @Override
    public void setProgress(int progress) {

    }

    @Override
    public void setProgressBarIndeterminate(boolean indeterminate) {

    }

    @Override
    public void setProgressBarIndeterminateVisibility(boolean visible) {

    }

    @Override
    public void setProgressBarVisibility(boolean visible) {

    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {

    }

    @Override
    public void setResult(int resultCode, Intent data) {

    }

    @Override
    public void setResult(int resultCode) {

    }

    @Override
    public void setSecondaryProgress(int secondaryProgress) {

    }

    @Override
    public void setShowWhenLocked(boolean showWhenLocked) {

    }

    @Override
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {

    }

    @Override
    public void setTitle(CharSequence title) {

    }

    @Override
    public void setTitle(int titleId) {

    }

    @Override
    public void setTitleColor(int textColor) {

    }

    @Override
    public void setTurnScreenOn(boolean turnScreenOn) {

    }

    @Override
    public void setVisible(boolean visible) {

    }

    @Override
    public void setVolumeControlStream(int streamType) {

    }

    @Override
    public void setVrModeEnabled(boolean enabled, ComponentName requestedComponent) throws PackageManager.NameNotFoundException {

    }

    @Override
    public boolean shouldShowRequestPermissionRationale(String permission) {
        return false;
    }

    @Override
    public boolean shouldUpRecreateTask(Intent targetIntent) {
        return false;
    }

    @Override
    public boolean showAssist(Bundle args) {
        return false;
    }

    @Override
    public boolean showDialog(int id, Bundle args) {
        return false;
    }

    @Override
    public void showDialog(int id) {

    }

    @Override
    public void showLockTaskEscapeMessage() {

    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        return null;
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) throws ActivityNotFoundException {

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) throws ActivityNotFoundException {

    }

    @Override
    public void startActivityFromChild(Activity child, Intent intent, int requestCode) throws ActivityNotFoundException {

    }

    @Override
    public void startActivityFromChild(Activity child, Intent intent, int requestCode, Bundle options) throws ActivityNotFoundException {

    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, Bundle options) throws ActivityNotFoundException {

    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) throws ActivityNotFoundException {

    }

    @Override
    public boolean startActivityIfNeeded(Intent intent, int requestCode, Bundle options) {
        return false;
    }

    @Override
    public boolean startActivityIfNeeded(Intent intent, int requestCode) {
        return false;
    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }

    @Override
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {

    }

    @Override
    public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {

    }

    @Override
    public void startLocalVoiceInteraction(Bundle privateOptions) {

    }

    @Override
    public void startLockTask() {

    }

    @Override
    public void startManagingCursor(Cursor c) {

    }

    @Override
    public boolean startNextMatchingActivity(Intent intent, Bundle options) {
        return false;
    }

    @Override
    public boolean startNextMatchingActivity(Intent intent) {
        return false;
    }

    @Override
    public void startPostponedEnterTransition() {

    }

    @Override
    public void startSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, boolean globalSearch) {

    }

    @Override
    public void stopLocalVoiceInteraction() {

    }

    @Override
    public void stopLockTask() {

    }

    @Override
    public void stopManagingCursor(Cursor c) {

    }

    @Override
    public void takeKeyEvents(boolean get) {

    }

    @Override
    public void triggerSearch(String query, Bundle appSearchData) {

    }

    @Override
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {

    }

    @Override
    public void unregisterForContextMenu(View view) {

    }

    @Override
    public void attachBaseContext(Context newBase) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {

    }

    @Override
    public void onChildTitleChanged(Activity childActivity, CharSequence title) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public Dialog onCreateDialog(int id) {
        return null;
    }

    @Override
    public Dialog onCreateDialog(int id, Bundle args) {
        return null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onPostResume() {

    }

    @Override
    public void onPrepareDialog(int id, Dialog dialog, Bundle args) {

    }

    @Override
    public void onPrepareDialog(int id, Dialog dialog) {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onTitleChanged(CharSequence title, int color) {

    }

    @Override
    public void onUserLeaveHint() {

    }
}
