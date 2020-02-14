import { Spider } from './spider';
import { config } from "./config";

(async function() {
    await Spider.fetchPendingApis(config.tasks);
})();