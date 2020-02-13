import { Spider } from './spider';

(async function() {
    await Spider.fetchActivityApis();
    await Spider.fetchServiceApis();
})();