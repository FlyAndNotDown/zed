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

public interface PluginActivityDefined {
    void addContentView(View view, ViewGroup.LayoutParams params);
    void closeContextMenu();
    void closeOptionsMenu();
    PendingIntent createPendingResult(int requestCode, Intent data, int flags);
    void dismissDialog(int id) throws IllegalArgumentException;
    void dismissKeyboardShortcutsHelper();
    boolean dispatchGenericMotionEvent(MotionEvent ev);
    boolean dispatchKeyEvent(KeyEvent event);
    boolean dispatchKeyShortcutEvent(KeyEvent event);
    boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event);
    boolean dispatchTouchEvent(MotionEvent ev);
    boolean dispatchTrackballEvent(MotionEvent ev);
    boolean enterPictureInPictureMode(PictureInPictureParams params);
    void enterPictureInPictureMode();
    <T extends View> T findViewById(int id);
    void finish();
    void finishActivity(int requestCode);
    void finishActivityFromChild(Activity child, int requestCode);
    void finishAffinity();
    void finishAfterTransition();
    void finishAndRemoveTask();
    void finishFromChild(Activity child);
    ActionBar getActionBar();
    Application getApplication();
    ComponentName getCallingActivity();
    String getCallingPackage();
    int getChangingConfigurations();
    ComponentName getComponentName();
    Scene getContentScene();
    TransitionManager getContentTransitionManager();
    View getCurrentFocus();
    FragmentManager getFragmentManager();
    Intent getIntent();
    Object getLastNonConfigurationInstance();
    LayoutInflater getLayoutInflater();
    LoaderManager getLoaderManager();
    String getLocalClassName();
    int getMaxNumPictureInPictureActions();
    MediaController getMediaController();
    MenuInflater getMenuInflater();
    Activity getParent();
    Intent getParentActivityIntent();
    SharedPreferences getPreferences(int mde);
    Uri getReferrer();
    int getRequestedOrientation();
    SearchEvent getSearchEvent();
    Object getSystemService(String name);
    int getTaskId();
    CharSequence getTitle();
    int getTitleColor();
    VoiceInteractor getVoiceInteractor();
    int getVolumeControlStream();
    Window getWindow();
    WindowManager getWindowManager();
    boolean hasWindowFocus();
    void invalidateOptionsMenu();
    boolean isActivityTransitionRunning();
    boolean isChangingConfigurations();
    boolean isChild();
    boolean isDestroyed();
    boolean isFinishing();
    boolean isImmersive();
    boolean isInMultiWindowMode();
    boolean isInPictureInPictureMode();
    boolean isLocalVoiceInteractionSupported();
    boolean isTaskRoot();
    boolean isVoiceInteraction();
    boolean isVoiceInteractionRoot();
    Cursor managedQuery(
        Uri uri,
        String[] projection,
        String selection,
        String[] selectionArgs,
        String sortOrder
    );
    boolean moveTaskToBack(boolean nonRoot);
    boolean navigateUpTo(Intent upIntent);
    boolean navigateUpToFromChild(Activity child, Intent upIntent);
    void onActionModeFinished(ActionMode mode);
    void onActionModeStarted(ActionMode mode);
    void onActivityReenter(int resultCode, Intent data);
    void onAttachFragment(Fragment fragment);
    void onAttachedToWindow();
    void onBackPressed();
    void onConfigurationChanged(Configuration newConfig);
    void onContentChanged();
    boolean onContextItemSelected(MenuItem item);
    void onContextMenuClosed(Menu menu);
    void onCreate(Bundle savedInstanceState, PersistableBundle persistentState);
    void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);
    CharSequence onCreateDescription();
    void onCreateNavigateUpTaskStack(TaskStackBuilder builder);
    boolean onCreateOptionsMenu(Menu menu);
    boolean onCreatePanelMenu(int featureId, Menu menu);
    View onCreatePanelView(int featureId);
    boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas);
    View onCreateView(View parent, String name, Context context, AttributeSet attrs);
    View onCreateView(String name, Context context, AttributeSet attrs);
    void onDetachedFromWindow();
    void onEnterAnimationComplete();
    boolean onGenericMotionEvent(MotionEvent event);
    void onGetDirectActions(
        CancellationSignal cancellationSignal,
        Consumer<List<DirectAction>> callback
    );
    boolean onKeyDown(int keyCode, KeyEvent event);
    boolean onKeyLongPress(int keyCode, KeyEvent event);
    boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event);
    boolean onKeyShortcut(int keyCode, KeyEvent event);
    boolean onKeyUp(int keyCode, KeyEvent event);
    void onLocalVoiceInteractionStarted();
    void onLocalVoiceInteractionStopped();
    void onLowMemory();
    boolean onMenuItemSelected(int featureId, MenuItem item);
    boolean onMenuOpened(int featureId, Menu menu);
    void onMultiWindowModeChanged(boolean isInMultiWindowMode);
    void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig);
    boolean onNavigateUp();
    boolean onNavigateUpFromChild(Activity child);
    boolean onOptionsItemSelected(MenuItem item);
    void onOptionsMenuClosed(Menu menu);
    void onPanelClosed(int featureId, Menu menu);
    void onPerformDirectAction(
        String actionId,
        Bundle arguments,
        CancellationSignal cancellationSignal,
        Consumer<Bundle> resultListener
    );
    void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig);
    void onPictureInPictureModeChanged(boolean isInPictureInPictureMode);
    void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState);
    void onPrepareNavigateUpTaskStack(TaskStackBuilder builder);
    boolean onPrepareOptionsMenu(Menu menu);
    boolean onPreparePanel(int featureId, View view, Menu menu);
    void onProvideAssistContent(AssistContent outContent);
    void onProvideAssistData(Bundle data);
    void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId);
    Uri onProvideReferrer();
    void onRequestPermissionsResult(
        int requestCode,
        String[] permissions,
        int[] grantResults
    ) throws IllegalArgumentException;
    void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState);
    Object onRetainNonConfigurationInstance();
    void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState);
    boolean onSearchRequested(SearchEvent searchEvent);
    boolean onSearchRequested();
    void onStateNotSaved();
    void onTopResumedActivityChanged(boolean isTopResumedActivity);
    boolean onTouchEvent(MotionEvent event);
    boolean onTrackballEvent(MotionEvent event);
    void onTrimMemory(int level);
    void onUserInteraction();
    void onVisibleBehindCanceled();
    void onWindowAttributesChanged(WindowManager.LayoutParams params);
    void onWindowFocusChanged(boolean hasFocus);
    ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type);
    ActionMode onWindowStartingActionMode(ActionMode.Callback callback);
    void openContextMenu(View view);
    void openOptionsMenu();
    void overridePendingTransition(int enterAnim, int exitAnim);
    void postponeEnterTransition();
    void recreate();
    void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback);
    void registerForContextMenu(View view);
    boolean releaseInstance();
    void removeDialog(int id);
    void reportFullyDrawn();
    DragAndDropPermissions requestDragAndDropPermissions(DragEvent event);
    void requestPermissions(String[] permissions, int requestCode);
    void requestShowKeyboardShortcuts();
    boolean requestVisibleBehind(boolean visible);
    boolean requestWindowFeature(int featureId);
    <T extends View> T requireViewById(int id);
    void runOnUiThread(Runnable action);
    void setActionBar(Toolbar toolbar);
    void setContentTransitionManager(TransitionManager tm);
    void setContentView(View view, ViewGroup.LayoutParams params);
    void setContentView(View view);
    void setContentView(int layoutResID);
    void setDefaultKeyMode(int mode);
    void setEnterSharedElementCallback(SharedElementCallback callback);
    void setExitSharedElementCallback(SharedElementCallback callback);
    void setFeatureDrawable(int featureId, Drawable drawable);
    void setFeatureDrawableAlpha(int featureId, int alpha);
    void setFeatureDrawableResource(int featureId, int resId);
    void setFeatureDrawableUri(int featureId, Uri uri);
    void setFinishOnTouchOutside(boolean finish);
    void setImmersive(boolean i);
    void setInheritShowWhenLocked(boolean inheritShowWhenLocked);
    void setIntent(Intent newIntent);
    void setMediaController(MediaController controller);
    void setPictureInPictureParams(PictureInPictureParams params);
    void setProgress(int progress);
    void setProgressBarIndeterminate(boolean indeterminate);
    void setProgressBarIndeterminateVisibility(boolean visible);
    void setProgressBarVisibility(boolean visible);
    void setRequestedOrientation(int requestedOrientation);
    void setResult(int resultCode, Intent data);
    void setResult(int resultCode);
    void setSecondaryProgress(int secondaryProgress);
    void setShowWhenLocked(boolean showWhenLocked);
    void setTaskDescription(ActivityManager.TaskDescription taskDescription);
    void setTheme(int resid);
    void setTitle(CharSequence title);
    void setTitle(int titleId);
    void setTitleColor(int textColor);
    void setTurnScreenOn(boolean turnScreenOn);
    void setVisible(boolean visible);
    void setVolumeControlStream(int streamType);
    void setVrModeEnabled(
        boolean enabled,
        ComponentName requestedComponent
    ) throws PackageManager.NameNotFoundException;
    boolean shouldShowRequestPermissionRationale(String permission);
    boolean shouldUpRecreateTask(Intent targetIntent);
    boolean showAssist(Bundle args);
    boolean showDialog(int id, Bundle args);
    void showDialog(int id);
    void showLockTaskEscapeMessage();
    ActionMode startActionMode(ActionMode.Callback callback, int type);
    ActionMode startActionMode(ActionMode.Callback callback);
    void startActivities(Intent[] intents, Bundle options) throws ActivityNotFoundException;
    void startActivities(Intent[] intents) throws ActivityNotFoundException;
    void startActivity(Intent intent) throws ActivityNotFoundException;
    void startActivity(Intent intent, Bundle options) throws ActivityNotFoundException;
    void startActivityForResult(Intent intent, int requestCode) throws ActivityNotFoundException;
    void startActivityForResult(
        Intent intent,
        int requestCode,
        Bundle options
    ) throws ActivityNotFoundException;
    void startActivityFromChild(
        Activity child,
        Intent intent,
        int requestCode
    ) throws ActivityNotFoundException;
    void startActivityFromChild(
        Activity child,
        Intent intent,
        int requestCode,
        Bundle options
    ) throws ActivityNotFoundException;
    void startActivityFromFragment(
        Fragment fragment,
        Intent intent,
        int requestCode,
        Bundle options
    ) throws ActivityNotFoundException;
    void startActivityFromFragment(
        Fragment fragment,
        Intent intent,
        int requestCode
    ) throws ActivityNotFoundException;
    boolean startActivityIfNeeded(Intent intent, int requestCode, Bundle options);
    boolean startActivityIfNeeded(Intent intent, int requestCode);
    void startIntentSender(
        IntentSender intent,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags
    ) throws IntentSender.SendIntentException;
    void startIntentSender(
        IntentSender intent,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags,
        Bundle options
    ) throws IntentSender.SendIntentException;
    void startIntentSenderForResult(
        IntentSender intent,
        int requestCode,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags
    ) throws IntentSender.SendIntentException;
    void startIntentSenderForResult(
        IntentSender intent,
        int requestCode,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags,
        Bundle options
    ) throws IntentSender.SendIntentException;
    void startIntentSenderFromChild(
        Activity child,
        IntentSender intent,
        int requestCode,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags,
        Bundle options
    ) throws IntentSender.SendIntentException;
    void startIntentSenderFromChild(
        Activity child,
        IntentSender intent,
        int requestCode,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags
    ) throws IntentSender.SendIntentException;
    void startLocalVoiceInteraction(Bundle privateOptions);
    void startLockTask();
    void startManagingCursor(Cursor c);
    boolean startNextMatchingActivity(Intent intent, Bundle options);
    boolean startNextMatchingActivity(Intent intent);
    void startPostponedEnterTransition();
    void startSearch(
        String initialQuery,
        boolean selectInitialQuery,
        Bundle appSearchData,
        boolean globalSearch
    );
    void stopLocalVoiceInteraction();
    void stopLockTask();
    void stopManagingCursor(Cursor c);
    void takeKeyEvents(boolean get);
    void triggerSearch(String query, Bundle appSearchData);
    void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback);
    void unregisterForContextMenu(View view);
    void attachBaseContext(Context newBase);
    void onActivityResult(int requestCode, int resultCode, Intent data);
    void onApplyThemeResource(Resources.Theme theme, int resid, boolean first);
    void onChildTitleChanged(Activity childActivity, CharSequence title);
    void onCreate(Bundle savedInstanceState);
    Dialog onCreateDialog(int id);
    Dialog onCreateDialog(int id, Bundle args);
    void onDestroy();
    void onNewIntent(Intent intent);
    void onPause();
    void onPostCreate(Bundle savedInstanceState);
    void onPostResume();
    void onPrepareDialog(int id, Dialog dialog, Bundle args);
    void onPrepareDialog(int id, Dialog dialog);
    void onRestart();
    void onRestoreInstanceState(Bundle savedInstanceState);
    void onResume();
    void onSaveInstanceState(Bundle outState);
    void onStart();
    void onStop();
    void onTitleChanged(CharSequence title, int color);
    void onUserLeaveHint();
}