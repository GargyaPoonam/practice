"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const lodash_1 = __importDefault(require("lodash"));
const extension_command_1 = __importDefault(require("./extension-command"));
const constants_1 = require("../constants");
require("@colors/colors");
const REQ_DRIVER_FIELDS = ['driverName', 'automationName', 'platformNames', 'mainClass'];
/**
 * @extends {ExtensionCliCommand<DriverType>}
 */
class DriverCliCommand extends extension_command_1.default {
    /**
     * @param {import('./extension-command').ExtensionCommandOptions<DriverType>} opts
     */
    constructor({ config, json }) {
        super({ config, json });
        this.knownExtensions = constants_1.KNOWN_DRIVERS;
    }
    /**
     * Install a driver
     *
     * @param {DriverInstallOpts} opts
     * @return {Promise<ExtRecord<DriverType>>}
     */
    async install({ driver, installType, packageName }) {
        return await super._install({
            installSpec: driver,
            installType,
            packageName,
        });
    }
    /**
     * Uninstall a driver
     *
     * @param {DriverUninstallOpts} opts
     * @return {Promise<ExtRecord<DriverType>>}
     */
    async uninstall({ driver }) {
        return await super._uninstall({ installSpec: driver });
    }
    /**
     * Update a driver
     *
     * @param {DriverUpdateOpts} opts
     * @return {Promise<import('./extension-command').ExtensionUpdateResult>}
     */
    async update({ driver, unsafe }) {
        return await super._update({ installSpec: driver, unsafe });
    }
    /**
     *
     * @param {DriverRunOptions} opts
     * @return {Promise<import('./extension-command').RunOutput>}
     */
    async run({ driver, scriptName, extraArgs }) {
        return await super._run({
            installSpec: driver,
            scriptName,
            extraArgs,
            bufferOutput: this.isJsonOutput,
        });
    }
    /**
     *
     * @param {import('./extension-command').ExtensionArgs} opts
     * @returns {string}
     */
    getPostInstallText({ extName, extData }) {
        return (`Driver ${extName}@${extData.version} successfully installed\n`.green +
            `- automationName: ${extData.automationName.green}\n` +
            `- platformNames: ${JSON.stringify(extData.platformNames).green}`);
    }
    /**
     * Validates fields in `appium` field of `driverMetadata`
     *
     * For any `package.json` fields which a driver requires, validate the type of
     * those fields on the `package.json` data, throwing an error if anything is
     * amiss.
     * @param {import('appium/types').ExtMetadata<DriverType>} driverMetadata
     * @param {string} installSpec
     */
    validateExtensionFields(driverMetadata, installSpec) {
        const missingFields = REQ_DRIVER_FIELDS.reduce((acc, field) => (driverMetadata[field] ? acc : [...acc, field]), []);
        if (!lodash_1.default.isEmpty(missingFields)) {
            throw new Error(`Driver "${installSpec}" did not expose correct fields for compability ` +
                `with Appium. Missing fields: ${JSON.stringify(missingFields)}`);
        }
    }
}
exports.default = DriverCliCommand;
/**
 * @typedef {import('@appium/types').ExtensionType} ExtensionType
 * @typedef {import('@appium/types').DriverType} DriverType
 */
/**
 * @template {ExtensionType} ExtType
 * @typedef {import('appium/types').ExtRecord<ExtType>} ExtRecord
 */
/**
 * @typedef DriverCommandOptions
 * @property {import('../extension/extension-config').ExtensionConfig<DriverType>} config
 * @property {boolean} json
 */
/**
 * Options for {@linkcode DriverCliCommand.install}
 * @typedef DriverInstallOpts
 * @property {string} driver - the name or spec of a driver to install
 * @property {InstallType} installType - how to install this driver. One of the INSTALL_TYPES
 * @property {string} [packageName] - for git/github installs, the driver node package name
 */
/**
 * @typedef {import('appium/types').InstallType} InstallType
 */
/**
 * Options for {@linkcode DriverCliCommand.uninstall}
 * @typedef DriverUninstallOpts
 * @property {string} driver - the name or spec of a driver to uninstall
 */
/**
 * Options for {@linkcode DriverCliCommand.update}
 * @typedef DriverUpdateOpts
 * @property {string} driver - the name of the driver to update
 * @property {boolean} unsafe - if true, will perform unsafe updates past major revision boundaries
 */
/**
 * Options for {@linkcode DriverCliCommand.run}.
 * @typedef DriverRunOptions
 * @property {string} driver - name of the driver to run a script from
 * @property {string} scriptName - name of the script to run
 * @property {string[]} [extraArgs] - arguments to pass to the script
 */
//# sourceMappingURL=driver-command.js.map