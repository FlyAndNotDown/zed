import {Downloader} from './spider/downloader';

async function main() {
    await Downloader.download('activity', 'https://developer.android.google.cn/reference/android/app/Activity?hl=en');
}

(async function() {
    await main();
})();