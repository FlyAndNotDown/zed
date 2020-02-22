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

public interface ContainerActivityCallback {
    void pureAddContentView(View view, ViewGroup.LayoutParams params);
    void pureCloseContextMenu();
    void pureCloseOptionsMenu();
    PendingIntent pureCreatePendingResult(int requestCode, Intent data, int flags);
    void pureDismissDialog(int id) throws IllegalArgumentException;
    void pureDismissKeyboardShortcutsHelper();
    boolean pureDispatchGenericMotionEvent(MotionEvent ev);
    boolean pureDispatchKeyEvent(KeyEvent event);
    boolean pureDispatchKeyShortcutEvent(KeyEvent event);
    boolean pureDispatchPopulateAccessibilityEvent(AccessibilityEvent event);
    boolean pureDispatchTouchEvent(MotionEvent ev);
    boolean pureDispatchTrackballEvent(MotionEvent ev);
    boolean pureEnterPictureInPictureMode(PictureInPictureParams params);
    void pureEnterPictureInPictureMode();
    <T extends View> T pureFindViewById(int id);
    void pureFinish();
    void pureFinishActivity(int requestCode);
    void pureFinishActivityFromChild(Activity child, int requestCode);
    void pureFinishAffinity();
    void pureFinishAfterTransition();
    void pureFinishAndRemoveTask();
    void pureFinishFromChild(Activity child);
    ActionBar pureGetActionBar();
    Application pureGetApplication();
    ComponentName pureGetCallingActivity();
    String pureGetCallingPackage();
    int pureGetChangingConfigurations();
    ClassLoader pureGetClassLoader();
    ComponentName pureGetComponentName();
    Scene pureGetContentScene();
    TransitionManager pureGetContentTransitionManager();
    View pureGetCurrentFocus();
    FragmentManager pureGetFragmentManager();
    Intent pureGetIntent();
    Object pureGetLastNonConfigurationInstance();
    LayoutInflater pureGetLayoutInflater();
    LoaderManager pureGetLoaderManager();
    String pureGetLocalClassName();
    int pureGetMaxNumPictureInPictureActions();
    MediaController pureGetMediaController();
    MenuInflater pureGetMenuInflater();
    Activity pureGetParent();
    Intent pureGetParentActivityIntent();
    SharedPreferences pureGetPreferences(int mode);
    Uri pureGetReferrer();
    int pureGetRequestedOrientation();
    SearchEvent pureGetSearchEvent();
    Object pureGetSystemService(String name);
    int pureGetTaskId();
    Resources.Theme pureGetTheme();
    CharSequence pureGetTitle();
    int pureGetTitleColor();
    VoiceInteractor pureGetVoiceInteractor();
    int pureGetVolumeControlStream();
    Window pureGetWindow();
    WindowManager pureGetWindowManager();
    boolean pureHasWindowFocus();
    void pureInvalidateOptionsMenu();
    boolean pureIsActivityTransitionRunning();
    boolean pureIsChangingConfigurations();
    boolean pureIsChild();
    boolean pureIsDestroyed();
    boolean pureIsFinishing();
    boolean pureIsImmersive();
    boolean pureIsInMultiWindowMode();
    boolean pureIsInPictureInPictureMode();
    boolean pureIsLocalVoiceInteractionSupported();
    boolean pureIsTaskRoot();
    boolean pureIsVoiceInteraction();
    boolean pureIsVoiceInteractionRoot();
    Cursor pureManagedQuery(
        Uri uri,
        String[] projection,
        String selection,
        String[] selectionArgs,
        String sortOrder
    );
    boolean pureMoveTaskToBack(boolean nonRoot);
    boolean pureNavigateUpTo(Intent upIntent);
    boolean pureNavigateUpToFromChild(Activity child, Intent upIntent);
    void pureOnActionModeFinished(ActionMode mode);
    void pureOnActionModeStarted(ActionMode mode);
    void pureOnActivityReenter(int resultCode, Intent data);
    void pureOnAttachFragment(Fragment fragment);
    void pureOnAttachedToWindow();
    void pureOnBackPressed();
    void pureOnConfigurationChanged(Configuration newConfig);
    void pureOnContentChanged();
    boolean pureOnContextItemSelected(MenuItem item);
    void pureOnContextMenuClosed(Menu menu);
    void pureOnCreate(Bundle savedInstanceState, PersistableBundle persistentState);
    void pureOnCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);
    CharSequence pureOnCreateDescription();
    void pureOnCreateNavigateUpTaskStack(TaskStackBuilder builder);
    boolean pureOnCreateOptionsMenu(Menu menu);
    boolean pureOnCreatePanelMenu(int featureId, Menu menu);
    View pureOnCreatePanelView(int featureId);
    boolean pureOnCreateThumbnail(Bitmap outBitmap, Canvas canvas);
    View pureOnCreateView(View parent, String name, Context context, AttributeSet attrs);
    View pureOnCreateView(String name, Context context, AttributeSet attrs);
    void pureOnDetachedFromWindow();
    void pureOnEnterAnimationComplete();
    boolean pureOnGenericMotionEvent(MotionEvent event);
    void pureOnGetDirectActions(
        CancellationSignal cancellationSignal,
        Consumer<List<DirectAction>> callback
    );
    boolean pureOnKeyDown(int keyCode, KeyEvent event);
    boolean pureOnKeyLongPress(int keyCode, KeyEvent event);
    boolean pureOnKeyMultiple(int keyCode, int repeatCount, KeyEvent event);
    boolean pureOnKeyShortcut(int keyCode, KeyEvent event);
    boolean pureOnKeyUp(int keyCode, KeyEvent event);
    void pureOnLocalVoiceInteractionStarted();
    void pureOnLocalVoiceInteractionStopped();
    void pureOnLowMemory();
    boolean pureOnMenuItemSelected(int featureId, MenuItem item);
    boolean pureOnMenuOpened(int featureId, Menu menu);
    void pureOnMultiWindowModeChanged(boolean isInMultiWindowMode);
    void pureOnMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig);
    boolean pureOnNavigateUp();
    boolean pureOnNavigateUpFromChild(Activity child);
    boolean pureOnOptionsItemSelected(MenuItem item);
    void pureOnOptionsMenuClosed(Menu menu);
    void pureOnPanelClosed(int featureId, Menu menu);
    void pureOnPerformDirectAction(
        String actionId,
        Bundle arguments,
        CancellationSignal cancellationSignal,
        Consumer<Bundle> resultListener
    );
    void pureOnPictureInPictureModeChanged(
        boolean isInPictureInPictureMode,
        Configuration newConfig
    );
    void pureOnPictureInPictureModeChanged(boolean isInPictureInPictureMode);
    void pureOnPostCreate(Bundle savedInstanceState, PersistableBundle persistentState);
    void pureOnPrepareNavigateUpTaskStack(TaskStackBuilder builder);
    boolean pureOnPrepareOptionsMenu(Menu menu);
    boolean pureOnPreparePanel(int featureId, View view, Menu menu);
    void pureOnProvideAssistContent(AssistContent outContent);
    void pureOnProvideAssistData(Bundle data);
    void pureOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId);
    Uri pureOnProvideReferrer();
    void pureOnRequestPermissionsResult(
        int requestCode,
        String[] permissions,
        int[] grantResults
    ) throws IllegalArgumentException;
    void pureOnRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState);
    Object pureOnRetainNonConfigurationInstance();
    void pureOnSaveInstanceState(Bundle outState, PersistableBundle outPersistentState);
    boolean pureOnSearchRequested(SearchEvent searchEvent);
    boolean pureOnSearchRequested();
    void pureOnStateNotSaved();
    void pureOnTopResumedActivityChanged(boolean isTopResumedActivity);
    boolean pureOnTouchEvent(MotionEvent event);
    boolean pureOnTrackballEvent(MotionEvent event);
    void pureOnTrimMemory(int level);
    void pureOnUserInteraction();
    void pureOnVisibleBehindCanceled();
    void pureOnWindowAttributesChanged(WindowManager.LayoutParams params);
    void pureOnWindowFocusChanged(boolean hasFocus);
    ActionMode pureOnWindowStartingActionMode(ActionMode.Callback callback, int type);
    ActionMode pureOnWindowStartingActionMode(ActionMode.Callback callback);
    void pureOpenContextMenu(View view);
    void pureOpenOptionsMenu();
    void pureOverridePendingTransition(int enterAnim, int exitAnim);
    void purePostponeEnterTransition();
    void pureRecreate();
    void pureRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback);
    void pureRegisterForContextMenu(View view);
    boolean pureReleaseInstance();
    void pureRemoveDialog(int id);
    void pureReportFullyDrawn();
    DragAndDropPermissions pureRequestDragAndDropPermissions(DragEvent event);
    void pureRequestPermissions(String[] permissions, int requestCode);
    void pureRequestShowKeyboardShortcuts();
    boolean pureRequestVisibleBehind(boolean visible);
    boolean pureRequestWindowFeature(int featureId);
    <T extends View> T pureRequireViewById(int id);
    void pureRunOnUiThread(Runnable action);
    void pureSetActionBar(Toolbar toolbar);
    void pureSetContentTransitionManager(TransitionManager tm);
    void pureSetContentView(View view, ViewGroup.LayoutParams params);
    void pureSetContentView(View view);
    void pureSetContentView(int layoutResID);
    void pureSetDefaultKeyMode(int mode);
    void pureSetEnterSharedElementCallback(SharedElementCallback callback);
    void pureSetExitSharedElementCallback(SharedElementCallback callback);
    void pureSetFeatureDrawable(int featureId, Drawable drawable);
    void pureSetFeatureDrawableAlpha(int featureId, int alpha);
    void pureSetFeatureDrawableResource(int featureId, int resId);
    void pureSetFeatureDrawableUri(int featureId, Uri uri);
    void pureSetFinishOnTouchOutside(boolean finish);
    void pureSetImmersive(boolean i);
    void pureSetInheritShowWhenLocked(boolean inheritShowWhenLocked);
    void pureSetIntent(Intent newIntent);
    void pureSetMediaController(MediaController controller);
    void pureSetPictureInPictureParams(PictureInPictureParams params);
    void pureSetProgress(int progress);
    void pureSetProgressBarIndeterminate(boolean indeterminate);
    void pureSetProgressBarIndeterminateVisibility(boolean visible);
    void pureSetProgressBarVisibility(boolean visible);
    void pureSetRequestedOrientation(int requestedOrientation);
    void pureSetResult(int resultCode, Intent data);
    void pureSetResult(int resultCode);
    void pureSetSecondaryProgress(int secondaryProgress);
    void pureSetShowWhenLocked(boolean showWhenLocked);
    void pureSetTaskDescription(ActivityManager.TaskDescription taskDescription);
    void pureSetTheme(int resid);
    void pureSetTitle(CharSequence title);
    void pureSetTitle(int titleId);
    void pureSetTitleColor(int textColor);
    void pureSetTurnScreenOn(boolean turnScreenOn);
    void pureSetVisible(boolean visible);
    void pureSetVolumeControlStream(int streamType);
    void pureSetVrModeEnabled(
        boolean enabled,
        ComponentName requestedComponent
    ) throws PackageManager.NameNotFoundException;
    boolean pureShouldShowRequestPermissionRationale(String permission);
    boolean pureShouldUpRecreateTask(Intent targetIntent);
    boolean pureShowAssist(Bundle args);
    boolean pureShowDialog(int id, Bundle args);
    void pureShowDialog(int id);
    void pureShowLockTaskEscapeMessage();
    ActionMode pureStartActionMode(ActionMode.Callback callback, int type);
    ActionMode pureStartActionMode(ActionMode.Callback callback);
    void pureStartActivities(Intent[] intents, Bundle options) throws ActivityNotFoundException;
    void pureStartActivities(Intent[] intents) throws ActivityNotFoundException;
    void pureStartActivity(Intent intent) throws ActivityNotFoundException;
    void pureStartActivity(Intent intent, Bundle options) throws ActivityNotFoundException;
    void pureStartActivityForResult(
        Intent intent,
        int requestCode
    ) throws ActivityNotFoundException;
    void pureStartActivityForResult(
        Intent intent,
        int requestCode,
        Bundle options
    ) throws ActivityNotFoundException;
    void pureStartActivityFromChild(
        Activity child,
        Intent intent,
        int requestCode
    ) throws ActivityNotFoundException;
    void pureStartActivityFromChild(
        Activity child,
        Intent intent,
        int requestCode,
        Bundle options
    ) throws ActivityNotFoundException;
    void pureStartActivityFromFragment(
        Fragment fragment,
        Intent intent,
        int requestCode,
        Bundle options
    ) throws ActivityNotFoundException;
    void pureStartActivityFromFragment(
        Fragment fragment,
        Intent intent,
        int requestCode
    ) throws ActivityNotFoundException;
    boolean pureStartActivityIfNeeded(Intent intent, int requestCode, Bundle options);
    boolean pureStartActivityIfNeeded(Intent intent, int requestCode);
    void pureStartIntentSender(
        IntentSender intent,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags
    ) throws IntentSender.SendIntentException;
    void pureStartIntentSender(
        IntentSender intent,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags,
        Bundle options
    ) throws IntentSender.SendIntentException;
    void pureStartIntentSenderForResult(
        IntentSender intent,
        int requestCode,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags
    ) throws IntentSender.SendIntentException;
    void pureStartIntentSenderForResult(
        IntentSender intent,
        int requestCode,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags,
        Bundle options
    ) throws IntentSender.SendIntentException;
    void pureStartIntentSenderFromChild(
        Activity child,
        IntentSender intent,
        int requestCode,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags,
        Bundle options
    ) throws IntentSender.SendIntentException;
    void pureStartIntentSenderFromChild(
        Activity child,
        IntentSender intent,
        int requestCode,
        Intent fillInIntent,
        int flagsMask,
        int flagsValues,
        int extraFlags
    ) throws IntentSender.SendIntentException;
    void pureStartLocalVoiceInteraction(Bundle privateOptions);
    void pureStartLockTask();
    void pureStartManagingCursor(Cursor c);
    boolean pureStartNextMatchingActivity(Intent intent, Bundle options);
    boolean pureStartNextMatchingActivity(Intent intent);
    void pureStartPostponedEnterTransition();
    void pureStartSearch(
        String initialQuery,
        boolean selectInitialQuery,
        Bundle appSearchData,
        boolean globalSearch
    );
    void pureStopLocalVoiceInteraction();
    void pureStopLockTask();
    void pureStopManagingCursor(Cursor c);
    void pureTakeKeyEvents(boolean get);
    void pureTriggerSearch(String query, Bundle appSearchData);
    void pureUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback);
    void pureUnregisterForContextMenu(View view);
    void pureAttachBaseContext(Context newBase);
    void pureOnActivityResult(int requestCode, int resultCode, Intent data);
    void pureOnApplyThemeResource(Resources.Theme theme, int resid, boolean first);
    void pureOnChildTitleChanged(Activity childActivity, CharSequence title);
    void pureOnCreate(Bundle savedInstanceState);
    Dialog pureOnCreateDialog(int id);
    Dialog pureOnCreateDialog(int id, Bundle args);
    void pureOnDestroy();
    void pureOnNewIntent(Intent intent);
    void pureOnPause();
    void pureOnPostCreate(Bundle savedInstanceState);
    void pureOnPostResume();
    void pureOnPrepareDialog(int id, Dialog dialog, Bundle args);
    void pureOnPrepareDialog(int id, Dialog dialog);
    void pureOnRestart();
    void pureOnRestoreInstanceState(Bundle savedInstanceState);
    void pureOnResume();
    void pureOnSaveInstanceState(Bundle outState);
    void pureOnStart();
    void pureOnStop();
    void pureOnTitleChanged(CharSequence title, int color);
    void pureOnUserLeaveHint();
}
