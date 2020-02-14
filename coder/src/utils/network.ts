import { default as Axios } from "axios";
import { LogUtil } from "./log";

export class NetworkUtil {
    public static async getSourceFromUrl(url: string): Promise<string> {
        let response = null;
        try {
            response = await Axios.get(url, {});
        } catch (e) {
            LogUtil.log('err', "network error");
        }
        if (response == null || response.data == null) {
            return "";
        }
        return response.data;
    }
}