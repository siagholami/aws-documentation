# npm command support<a name="npm-commands"></a>

The following sections summarize the `npm` commands that are supported, by CodeArtifact repositories, in addition to specific commands that are not supported\.

**Topics**
+ [Supported commands that interact with a repository](#supported-commands-that-interact-with-a-repository)
+ [Supported client\-side commands](#supported-client-side-commands)
+ [Unsupported commands](#unsupported-commands)

## Supported commands that interact with a repository<a name="supported-commands-that-interact-with-a-repository"></a>

This section lists `npm` commands where the `npm` client makes one or more requests to the registry it's been configured with \(for example, with `npm config set registry` \)\. These commands have been verified to function correctly when invoked against an CodeArtifact repository\.


****  

| Command | Description | 
| --- | --- | 
|   [bugs](https://docs.npmjs.com/cli/bugs)   |  Tries to guess the location of a package’s bug tracker URL, and then tries to open it\.  | 
|   [ci](https://docs.npmjs.com/cli/ci)   |  Installs a project with a clean slate\.  | 
|   [deprecate](https://docs.npmjs.com/cli/deprecate)   |  Deprecates a version of a package\.  | 
|   [dist\-tag](https://docs.npmjs.com/cli/dist-tag)   |  Modifies package distribution tags\.  | 
|   [docs](https://docs.npmjs.com/cli/docs)   |  Tries to guess the location of a package’s documentation URL, and then tries to open it using the `--browser` config parameter\.  | 
|   [doctor](https://docs.npmjs.com/cli/doctor)   |  Runs a set of checks to ensure that your npm installation has what it needs to manage your JavaScript packages\.  | 
|   [install](https://docs.npmjs.com/cli/install)   |  Installs a package\.  | 
|   [install\-ci\-test](https://docs.npmjs.com/cli/install-ci-test)   |  Installs a project with a clean slate and runs tests\. Alias: `npm cit`\. This command runs an `npm ci` followed immediately by an `npm test`\.  | 
|   [install\-test](https://docs.npmjs.com/cli/install-test)   |  Installs package and runs tests\. Runs an `npm install` followed immediately by an `npm test`\.  | 
|   [outdated](https://docs.npmjs.com/cli/outdated)   |  Checks the configured registry to see if any installed packages are currently outdated\.  | 
|   [ping](https://docs.npmjs.com/cli/ping)   |  Pings the configured or given npm registry and verifies authentication\.  | 
|   [publish](https://docs.npmjs.com/cli/publish)   |  Publishes a package version to the registry\.  | 
|   [update](https://docs.npmjs.com/cli/update)   |  Guesses the location of a package’s repository URL, and then tries to open it using the `--browser` config parameter\.  | 
|   [view](https://docs.npmjs.com/cli/view)   |  Displays package metadata\. Can be used to print metadata properties\.  | 

## Supported client\-side commands<a name="supported-client-side-commands"></a>

These commands don't require any direct interaction with a repository, so CodeArtifact does not need to do anything to support them\.


****  

| Command | Description | 
| --- | --- | 
|   [bin](https://docs.npmjs.com/cli/bin)   |  Displays the npm `bin` folder\.  | 
|   [build](https://docs.npmjs.com/cli/build)   |  Builds a package\.  | 
|   [cache](https://docs.npmjs.com/cli/cache)   |  Manipulates the packages cache\.  | 
|   [completion](https://docs.npmjs.com/cli/completion)   |  Enables tab completion in all npm commands\.  | 
|   [config](https://docs.npmjs.com/cli/config)   |  Updates the contents of the user and global `npmrc` files\.  | 
|   [dedupe](https://docs.npmjs.com/cli/dedupe)   |  Searches the local package tree and attempts to simplify the structure by moving dependencies further up the tree, where they can be more effectively shared by multiple dependent packages\.  | 
|   [edit](https://docs.npmjs.com/cli/edit)   |  Edits an installed package\. Selects a dependency in the current working directory and opens the package folder in the default editor\.  | 
|   [explore](https://docs.npmjs.com/cli/explore)   |  Browses an installed package\. Spawns a subshell in the directory of the installed package specified\. If a command is specified, then it is run in the subshell, which then immediately terminates\.  | 
|   [help](https://docs.npmjs.com/cli/help)   |  Gets help on npm\.  | 
|   [help\-search](https://docs.npmjs.com/cli/help-search)   |  Searches npm help documentation\.  | 
|   [init](https://docs.npmjs.com/cli/init)   |  Interactively creates a `package.json` file\.  | 
|   [link](https://docs.npmjs.com/cli/link)   |  Symlink a package folder\.  | 
|   [ls](https://docs.npmjs.com/cli/ls)   |  Lists installed packages\.  | 
|   [pack](https://docs.npmjs.com/cli/pack)   |  Creates a tarball from a package\.  | 
|   [prefix](https://docs.npmjs.com/cli/prefix)   |  Displays prefix\. This is the closest parent directory to contain a `package.json` file unless `-g` is also specified\.  | 
|   [prune](https://docs.npmjs.com/cli/prune)   |  Removes packages that are not listed on the parent package's dependencies list\.  | 
|   [rebuild](https://docs.npmjs.com/cli/rebuild)   |  Runs the `npm build` command on the matched folders\.  | 
|   [restart](https://docs.npmjs.com/cli/restart)   |  Runs a package's stop, restart, and start scripts and associated pre\- and post\- scripts\.  | 
|   [root](https://docs.npmjs.com/cli/root)   |  Prints the effective `node_modules` folder to standard out\.  | 
|   [run\-script](https://docs.npmjs.com/cli/run-script)   |  Runs arbitrary package scripts\.  | 
|   [shrinkwrap](https://docs.npmjs.com/cli/shrinkwrap)   |  Locks down dependency versions for publication\.  | 
|   [uninstall](https://docs.npmjs.com/cli/uninstall)   |  Uninstalls a package\.  | 

## Unsupported commands<a name="unsupported-commands"></a>

These `npm` commands are not supported by CodeArtifact repositories\.


****  

| Command | Description | Notes | 
| --- | --- | --- | 
|   [access](https://docs.npmjs.com/cli/access)   |  Sets the access level on published packages\.  |  CodeArtifact uses a permission model that is different from the public npmjs repository\.  | 
|   [adduser](https://docs.npmjs.com/cli/adduser)   |  Adds a registry user account  |  CodeArtifact uses a user model that is different from the public npmjs repository\.  | 
|   [audit](https://docs.npmjs.com/cli/audit)   |  Runs a security audit\.  |  CodeArtifact does not currently vend security vulnerability data\.  | 
|   [hook](https://docs.npmjs.com/cli/hook)   |  Allows you to manage npm hooks, including adding, removing, listing, and updating\.  |  CodeArtifact does not currently support any kind of change notification mechanism\.  | 
|   [login](https://docs.npmjs.com/cli-commands/adduser.html)   |  Authenticates a user\. This is an alias for `npm adduser`\.   |  CodeArtifact uses an authentication model that is different from the public npmjs repository\. For information, see [Authentication with npm](npm-auth.md)\.  | 
|   [logout](https://docs.npmjs.com/cli/logout)   |  Signs out of the registry\.  |  CodeArtifact uses an authentication model that is different from the public npmjs repository\. There is no way to sign out from an CodeArtifact repository, but authentication tokens expire after their configurable expiration time\. The default token duration is 12 hours\.   | 
|   [owner](https://docs.npmjs.com/cli/owner)   |  Manages package owners\.  |  CodeArtifact uses a permissions model that is different from the public npmjs repository\.  | 
|   [profile](https://docs.npmjs.com/cli/profile)   |  Changes settings on your registry profile\.  |  CodeArtifact uses a user model that is different from the public npmjs repository\.  | 
|   [search](https://docs.npmjs.com/cli/search)   |  Searches the registry for packages matching the search terms\.  |  CodeArtifact supports limited search functionality with the [list\-packages](list-packages.md) command\.  | 
|   [star](https://docs.npmjs.com/cli/star)   |  Marks your favorite packages\.  |  CodeArtifact currently does not support any kind of favorites mechanism\.  | 
|   [stars](https://docs.npmjs.com/cli/stars)   |  View packages marked as favorites\.  |  CodeArtifact currently does not support any kind of favorites mechanism\.  | 
|   [team](https://docs.npmjs.com/cli/team)   |  Manages organization teams and team memberships\.  |  CodeArtifact uses a user and group membership model that is different from the public npmjs repository\. For information, see [Identities \(Users, Groups, and Roles\)](https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html) in the *IAM User Guide*\.  | 
|   [token](https://docs.npmjs.com/cli/token)   |  Manages your authentication tokens\.  |  CodeArtifact uses a different model for getting authentication tokens\. For information, see [Authentication with npm](npm-auth.md)\.  | 
|   [unpublish](https://docs.npmjs.com/cli/unpublish)   |  Removes a package from the registry\.  |  CodeArtifact does not support removing a package version from a repository using the npm client\. You can use the [delete\-package\-version](delete-package.md) command\.  | 
|   [whoami](https://docs.npmjs.com/cli/whoami)   |  Displays the npm user name\.  |  CodeArtifact uses a user model that is different from the public npmjs repository\.  | 