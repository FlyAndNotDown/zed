import { default as Axios } from 'axios';
import { Log } from "./log";

export class Utils {
    public static async getSourceFromUrl(url: string): Promise<string> {
        let response = null;
        try {
            response = await Axios.get(url, {});
        } catch (e) {
            Log.log('err', "network error");
        }
        if (response == null) {
            return "";
        }
        if (response.data == null) {
            return "";
        }
        if (response.data.body == null) {
            return "";
        }
        return response.data.body;
    }
}