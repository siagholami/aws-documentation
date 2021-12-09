# List of Patches for Amazon Corretto 8<a name="patches"></a>

This section lists all the patches applied to OpenJDK for Amazon Corretto 8\. We also provide links to the issues in the OpenJDK project\.

**\[C8\-1\] Prevent premature OutOfMemoryException when G1 GC invocation is suspended by a long\-running native call\.**  
 Programs that use the G1 GC could experience spurious out\-of\-memory \(OOM\) exceptions even when the Java heap was far from filled up\. This happened when a spin loop that waited for long\-running native calls gave up after only two rounds\. This small patch makes this loop wait as long as it takes\. Typically a few more rounds suffice\. Worst case, a full GC would eventually occur \(thanks to JDK\-8137099\) and also resolve the issue\. The patch includes a unit test that provokes needing more than two rounds, and succeeds only if the patch is in place\. See [JDK\-8137099](https://bugs.openjdk.java.net/browse/JDK-8137099) for discussion\.

**\[C8\-2\] Back port from OpenJDK 10, fixing [JDK\-8177809](https://bugs.openjdk.java.net/browse/JDK-8177809): “File\.lastModified\(\) is losing milliseconds \(always ends in 000\)”\.**  
 The patch removes inconsistencies in how the last\-modified timestamp of a file is reported\. It standardizes the behavior across build platforms and Java methods so that the user receives second\-level precision\. See [JDK\-8177809](https://bugs.openjdk.java.net/browse/JDK-8177809)\. 

**\[C8\-3\] Back port from OpenJDK9, fixing JDK\-8150013, “ParNew: Prune nmethods scavengable list”\.**  
 This patch reduces pause latencies for the Parallel and the CMS garbage collector\. GC “root scanning” speeds up by up to three orders of magnitude by reducing redundant code inspections\. 

**\[C8\-4\] Back port from OpenJDK 9, fixing [JDK\-8047338](https://bugs.openjdk.java.net/browse/JDK-8047338): “javac is not correctly filtering non\-members methods to obtain the function descriptor”\.**  
 This patch fixes a compiler bug that caused compile\-time errors when a functional interface threw an exception that extend Exception\. 

**\[C8\-5\] Back port from OpenJDK 10, fixing [JDK\-8144185](https://bugs.openjdk.java.net/browse/JDK-8144185): “javac produces incorrect RuntimeInvisibleTypeAnnotations length attribute”\.**  
 This problem made Findbugs, JaCoCo, and Checker Framework fail on some well\-formed input programs\. 

**\[C8\-6\] Trigger string table cleanup in G1 based on string table growth\.**  
 This patch triggers “mixed” G1 collections needed to clean out the string table entries based on string table growth, not just Java heap use\. The latter is an independent measurement and may trigger too rarely or even never, in some applications\. Then the string table may grow without bounds, which is effectively a native memory leak\. See [JDK\-8213198](https://bugs.openjdk.java.net/browse/JDK-8213198)\. 

**\[C8\-7\] Backport from OpenJDK 9, fixing [JDK\-8149442](https://bugs.openjdk.java.net/browse/JDK-8149442): “MonitorInUseLists should be on by default, deflate idle monitors taking too long”\.**  
 This patch makes removing a performance bottleneck for highly thread\-intensive applications the default setting\. Enabling MonitorInUseLists allows more efficient deflation of only potentially in\-use monitors, instead of the entire population of monitors\. 

**\[C8\-8\] Back port from OpenJDK 11, fixing [JDK\-8198794](https://bugs.openjdk.java.net/browse/JDK-8198794): “Hotspot crash on Cassandra 3\.11\.1 startup with libnuma 2\.0\.3”\. **  
 This patch prevents Cassandra 3\.11\.1 from crashing at startup\. 

**\[C8\-9\] Back port from OpenJDK 11, fixing [JDK\-8195115](https://bugs.openjdk.java.net/browse/JDK-8195115): “G1 Old Gen MemoryPool CollectionUsage\.used values don't reflect mixed GC results”\. **  
 Without this patch, it's impossible to determine how full the heap is by means of JMX when using the G1 GC\. 

**\[C8\-10\] Speed up Class\.getSimpleName\(\) and Class\.getCanonicalName\(\)\.**  
 Memorization greatly speeds up these functions\. This patch includes correctness unit tests\. See [JDK\-8187123](https://bugs.openjdk.java.net/browse/JDK-8187123)\. 

**\[C8\-11\] Back port of JDK\-8068736 from OpenJDK9, fixing “Avoid synchronization on Executable/Field\.declaredAnnotations”\.**  
 Improves the performance of Executable/Field\.declaredAnnotations\(\) by result caching that avoids thread synchronization\. 

**\[C8\-12\] Back port from OpenJDK 9, fixing [JDK\-8077605](https://bugs.openjdk.java.net/browse/JDK-8077605): “Initializing static fields causes unbounded recursion in javac”\.**  

**\[C8\-13\] Fixed JDK\-8130493: “javac silently ignores malformed classes in the annotation processor”\. **  
 javac silently swallowed malformed class files in an annotation processor and returned with exit code 0\. With this patch, javac reports an error message and returns with a non\-zero exit code\. 

**\[C8\-14\] Improved error message for the jmap tool\.**  
 Updated error messages to suggest additional approaches when the target process is unresponsive\. See [JDK\-8213443](https://bugs.openjdk.java.net/browse/JDK-8213443)\. 

**\[C8\-15\] Fixed JDK\-8185005: “Improve performance of ThreadMXBean\.getThreadInfo\(long ids\[\], int maxDepth\)”\.**  
 This patch improves the performance of a JVM\-internal function that looks up a Java Thread instance from an OS thread ID\. This benefits several ThreadMXBean calls such as getThreadInfo\(\), getThreadCpuTime\(\), and getThreadUserTime\(\)\. The relative performance improvement increases with the number of threads in the JVM, as linear search is replaced by a hash table lookup\. 

**\[C8\-16\] Back port from OpenJDK 12, fixing [JDK\-8206075](https://bugs.openjdk.java.net/browse/JDK-8206075): “On x86, assert on unbound assembler Labels used as branch targets”\.**  
 Label class instances \(used to define pseudo\-assembly code\) can be used incorrectly in both the C1 and Interpreter\. The most common mistake for a label is being "branched to" but never defined as a location in code via bind\(\)\. An assert was added to catch these and thus triggered 106 jtreg/hotspot and 17 jtreg/jdk test failures\. We then determined that the label backedge\_counter\_overflow was not bound when UseLoopCounter was True, but UseOnStackReplacement was False\. This is now fixed and guarded by the above tests\. 

**\[C8\-17\] Improve portability of JVM source code when using gcc7\.**  
 This patch places up\-to\-date type declarations in all places where the gcc switch “\-Wno\-deprecated\-declarations” would flag problems\. It also enables the switch to catch future related issues\. This makes the source code compile on all present Amazon Linux versions\. This is a combination of much of [JDK\-8152856](https://bugs.openjdk.java.net/browse/JDK-8152856), [JDK\-8184309](https://bugs.openjdk.java.net/browse/JDK-8184309), [JDK\-8185826](https://bugs.openjdk.java.net/browse/JDK-8185826), [JDK\-8185900](https://bugs.openjdk.java.net/browse/JDK-8185900), [JDK\-8187676](https://bugs.openjdk.java.net/browse/JDK-8187676), [JDK\-8196909](https://bugs.openjdk.java.net/browse/JDK-8196909), [JDK\-8196985](https://bugs.openjdk.java.net/browse/JDK-8196985), [JDK\-8199685](https://bugs.openjdk.java.net/browse/JDK-8199685), [JDK\-8200052](https://bugs.openjdk.java.net/browse/JDK-8200052), [JDK\-8200110](https://bugs.openjdk.java.net/browse/JDK-8200110), [JDK\-8209786](https://bugs.openjdk.java.net/browse/JDK-8209786), [JDK\-8210836](https://bugs.openjdk.java.net/browse/JDK-8210836), [JDK\-8211146](https://bugs.openjdk.java.net/browse/JDK-8211146), [JDK\-8211370](https://bugs.openjdk.java.net/browse/JDK-8211370), [JDK\-8211929](https://bugs.openjdk.java.net/browse/JDK-8211929), [JDK\-8213414](https://bugs.openjdk.java.net/browse/JDK-8213414), and [JDK\-8213575](https://bugs.openjdk.java.net/browse/JDK-8213575)\. 

**\[C8\-18\] Back port from JDK 10, fixing [JDK\-8195848](https://bugs.openjdk.java.net/browse/JDK-8195848): “JTREG test for StartManagementAgent fails”\.**  
 See [http://serviceability\-dev\.openjdk\.java\.narkive\.com/cDFwZce9](http://serviceability-dev.openjdk.java.narkive.com/cDFwZce9) for more details\. 

**\[C8\-19\] Re\-enables a legacy/disabled cipher suite to pass two TCK tests that would otherwise fail\.**  
 

**Three backports from OpenJDK9 to support using preinstalled libraries\.**  
 Backported items: [JDK\-8043805 for libjpeg](https://bugs.openjdk.java.net/browse/JDK-8043805), [JDK\-8035341 for libpng](https://bugs.openjdk.java.net/browse/JDK-8035341), and [JDK\-8042159 for lcms2](https://bugs.openjdk.java.net/browse/JDK-8042159)\. 

**Integration of aarch64 support from IcedTea 3\.8\.**  
 

**Updates to vendor\-related metadata\.**  
Identifies Amazon as the vendor of this OpenJDK distribution and adds hyperlinks for reporting issues\.

**Back port from OpenJDK 9, fixing [JDK\-8048782](https://bugs.openjdk.java.net/browse/JDK-8048782): “OpenJDK: PiscesCache : xmax/ymax rounding up can cause RasterFormatException”\.**  
 The bug is related to sun\.java2d\.pisces\.PiscesCache constructor that accepts '\(int minx,int miny,int maxx,int maxy\)' arguments: the internal 'bboxX1' and 'bboxY1' are set to values one greater than given maximum X and Y values\. 