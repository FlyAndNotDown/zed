import { Coder } from "./core/coder";
import { config } from "./config";

(async function() {
    await Coder.executeCodingTasks(config.tasks);
})();