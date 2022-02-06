## Reproduce the Issue

`mvn clean package`

### The Issue
```
[ERROR] Exception executing task org.dominokit:domino-jackson:1.0.0-RC3/transpiled_js
com.google.j2cl.common.visitor.ProcessorError: Context:

void BaseCollectionJsonDeserializer.setBackReference(String referenceName, Object reference, C value, JsonDeserializationContext ctx) {
  if (((null != value) && !value.isEmpty())) {
    for (T val : value) {
      BaseCollectionJsonDeserializer.this.deserializer.setBackReference(referenceName,reference,val,ctx);
    }
  }
}

    at com.google.j2cl.transpiler.ast.Visitor_ForEachStatement.visit (Visitor_ForEachStatement.java:27)
...
Caused by: com.google.j2cl.common.visitor.ProcessorError: Error while processing:

for (T val : value) {
  BaseCollectionJsonDeserializer.this.deserializer.setBackReference(referenceName,reference,val,ctx);
}

    at com.google.j2cl.transpiler.ast.Visitor_ForEachStatement.visit (Visitor_ForEachStatement.java:27)
...
Caused by: java.lang.ClassCastException: class com.google.j2cl.transpiler.ast.AutoValue_TypeVariable cannot be cast to class com.google.j2cl.transpiler.ast.DeclaredTypeDescriptor (com.google.j2cl.transpiler.ast.AutoValue_TypeVariable and com.google.j2cl.transpiler.ast.DeclaredTypeDescriptor are in unnamed module of loader org.codehaus.plexus.classworlds.realm.ClassRealm @5c7dfc05)
    at com.google.j2cl.transpiler.ast.TypeDescriptor.toBoxedType (TypeDescriptor.java:149)
...
```


### Full Logs
```
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< com.example:j2cl-domino-jackson-bug >-----------------
[INFO] Building j2cl-domino-jackson-bug 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ j2cl-domino-jackson-bug ---
[INFO] Deleting LOCALDIR\j2cl-problem\j2cl-domino-jackson-bug\target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ j2cl-domino-jackson-bug ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory LOCALDIR\j2cl-problem\j2cl-domino-jackson-bug\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ j2cl-domino-jackson-bug ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to LOCALDIR\j2cl-problem\j2cl-domino-jackson-bug\target\classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[INFO] 
[INFO] --- j2cl-maven-plugin:0.19-SNAPSHOT:build (build-js) @ j2cl-domino-jackson-bug ---
[INFO] Removing dependency com.google.jsinterop:jsinterop-annotations:jar:2.0.0:compile, no replacement
[INFO] Removing dependency com.google.jsinterop:base:jar:1.0.0:compile, replacing with com.vertispan.jsinterop:base:jar:1.0.0-SNAPSHOT
[INFO] Removing dependency com.google.jsinterop:base:jar:1.0.0:compile, replacing with com.vertispan.jsinterop:base:jar:1.0.0-SNAPSHOT
[INFO] Removing dependency com.google.jsinterop:base:jar:1.0.0:compile, replacing with com.vertispan.jsinterop:base:jar:1.0.0-SNAPSHOT
[INFO] Removing dependency com.google.jsinterop:jsinterop-annotations:jar:2.0.0:compile, no replacement
[INFO] Removing dependency com.google.jsinterop:base:jar:1.0.0:compile, replacing with com.vertispan.jsinterop:base:jar:1.0.0-SNAPSHOT
[INFO] Removing dependency com.google.jsinterop:jsinterop-annotations:jar:2.0.0:compile, no replacement
[INFO] Removing dependency com.google.jsinterop:base:jar:1.0.0:compile, replacing with com.vertispan.jsinterop:base:jar:1.0.0-SNAPSHOT
[INFO] Removing dependency com.google.jsinterop:base:jar:1.0.0:compile, replacing with com.vertispan.jsinterop:base:jar:1.0.0-SNAPSHOT
[INFO] Removing dependency com.google.jsinterop:jsinterop-annotations:jar:2.0.0:compile, no replacement
[INFO] Removing dependency com.google.jsinterop:base:jar:1.0.0:compile, replacing with com.vertispan.jsinterop:base:jar:1.0.0-SNAPSHOT
[INFO] Removing dependency com.google.jsinterop:base:jar:1.0.0:compile, replacing with com.vertispan.jsinterop:base:jar:1.0.0-SNAPSHOT
[INFO] Removing dependency com.google.jsinterop:base:jar:1.0.0:compile, replacing with com.vertispan.jsinterop:base:jar:1.0.0-SNAPSHOT
[INFO] Starting org.dominokit:domino-jackson:1.0.0-RC3/unpack
[INFO] Finished org.dominokit:domino-jackson:1.0.0-RC3/unpack in 692ms
[INFO] Starting org.dominokit:domino-jackson-super:1.0.0-RC3/unpack
[INFO] Finished org.dominokit:domino-jackson-super:1.0.0-RC3/unpack in 92ms
[INFO] Starting org.dominokit.i18n:gwt-cldr:1.0/unpack
[INFO] Finished org.dominokit.i18n:gwt-cldr:1.0/unpack in 5757ms
[INFO] Starting org.dominokit.i18n:gwt-datetimeformat:1.0/unpack
[INFO] Finished org.dominokit.i18n:gwt-datetimeformat:1.0/unpack in 32ms
[INFO] Starting org.dominokit.i18n:gwt-i18n:1.0/unpack
[INFO] Finished org.dominokit.i18n:gwt-i18n:1.0/unpack in 49ms
[INFO] Starting org.dominokit:domino-jackson-processor:1.0.0-RC3/unpack
[INFO] Finished org.dominokit:domino-jackson-processor:1.0.0-RC3/unpack in 2183ms
[INFO] Starting com.google.elemental2:elemental2-core:1.1.0/unpack
[INFO] Finished com.google.elemental2:elemental2-core:1.1.0/unpack in 150ms
[INFO] Starting com.google.jsinterop:jsinterop-annotations:2.0.0/unpack
[INFO] Finished com.google.jsinterop:jsinterop-annotations:2.0.0/unpack in 11ms
[INFO] Starting com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/unpack
[INFO] Finished com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/unpack in 20ms
[INFO] Starting com.google.elemental2:elemental2-dom:1.1.0/unpack
[INFO] Finished com.google.elemental2:elemental2-dom:1.1.0/unpack in 917ms
[INFO] Starting com.google.elemental2:elemental2-webgl:1.1.0/unpack
[INFO] Finished com.google.elemental2:elemental2-webgl:1.1.0/unpack in 67ms
[INFO] Starting com.google.elemental2:elemental2-promise:1.1.0/unpack
[INFO] Finished com.google.elemental2:elemental2-promise:1.1.0/unpack in 14ms
[INFO] Starting com.google.elemental2:elemental2-webgl:1.1.0/generated_sources
[INFO] Starting org.dominokit.i18n:gwt-cldr:1.0/generated_sources
[INFO] Starting org.dominokit.i18n:gwt-i18n:1.0/bytecode
[INFO] Starting org.dominokit.i18n:gwt-i18n:1.0/generated_sources
[INFO] Finished org.dominokit.i18n:gwt-i18n:1.0/bytecode in 65ms
[INFO] Starting org.dominokit:domino-jackson-super:1.0.0-RC3/generated_sources
[INFO] Starting org.dominokit.i18n:gwt-i18n:1.0/stripped_sources
[INFO] Starting com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/generated_sources
[INFO] Starting org.dominokit.i18n:gwt-cldr:1.0/bytecode
[INFO] Starting com.google.jsinterop:jsinterop-annotations:2.0.0/bytecode
[INFO] Starting org.dominokit.i18n:gwt-cldr:1.0/stripped_sources
[INFO] Finished com.google.jsinterop:jsinterop-annotations:2.0.0/bytecode in 19ms
[INFO] Starting com.google.elemental2:elemental2-webgl:1.1.0/bytecode
[INFO] Finished org.dominokit.i18n:gwt-i18n:1.0/stripped_sources in 212ms
[INFO] Finished com.google.elemental2:elemental2-webgl:1.1.0/bytecode in 159ms
[INFO] Starting com.google.elemental2:elemental2-promise:1.1.0/generated_sources
[INFO] Starting com.google.elemental2:elemental2-webgl:1.1.0/stripped_sources
[INFO] Finished com.google.elemental2:elemental2-webgl:1.1.0/stripped_sources in 38ms
[INFO] Starting com.google.elemental2:elemental2-dom:1.1.0/bytecode
[INFO] Starting com.google.elemental2:elemental2-core:1.1.0/generated_sources
[INFO] Starting com.google.jsinterop:jsinterop-annotations:2.0.0/generated_sources
[INFO] Starting com.google.elemental2:elemental2-dom:1.1.0/generated_sources
[INFO] Starting com.google.elemental2:elemental2-core:1.1.0/bytecode
[INFO] Finished com.google.elemental2:elemental2-core:1.1.0/bytecode in 318ms
[INFO] Starting com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/bytecode
[INFO] Finished com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/bytecode in 33ms
[INFO] Starting com.google.elemental2:elemental2-promise:1.1.0/bytecode
[INFO] Finished com.google.elemental2:elemental2-promise:1.1.0/bytecode in 18ms
[INFO] Starting org.dominokit:domino-jackson-processor:1.0.0-RC3/bytecode
[INFO] Finished com.google.elemental2:elemental2-dom:1.1.0/bytecode in 2146ms
[INFO] Starting org.dominokit:domino-jackson:1.0.0-RC3/bytecode
[INFO] Finished org.dominokit.i18n:gwt-cldr:1.0/stripped_sources in 3893ms
[INFO] Finished org.dominokit:domino-jackson:1.0.0-RC3/bytecode in 680ms
[INFO] Starting org.dominokit.i18n:gwt-datetimeformat:1.0/bytecode
[INFO] Finished org.dominokit.i18n:gwt-datetimeformat:1.0/bytecode in 39ms
[INFO] Starting org.dominokit.i18n:gwt-datetimeformat:1.0/generated_sources
[INFO] Starting org.dominokit:domino-jackson:1.0.0-RC3/generated_sources
[INFO] Starting org.dominokit:domino-jackson-super:1.0.0-RC3/bytecode
[INFO] Finished org.dominokit:domino-jackson-super:1.0.0-RC3/bytecode in 97ms
[INFO] Starting org.dominokit:domino-jackson-processor:1.0.0-RC3/generated_sources
[INFO] Starting org.dominokit:domino-jackson-super:1.0.0-RC3/stripped_sources
[INFO] Finished org.dominokit:domino-jackson-super:1.0.0-RC3/stripped_sources in 31ms
[INFO] Starting com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/stripped_sources
[INFO] Finished com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/stripped_sources in 13ms
[INFO] Starting com.google.elemental2:elemental2-promise:1.1.0/stripped_sources
[INFO] Starting com.google.elemental2:elemental2-core:1.1.0/stripped_sources
[INFO] Finished com.google.elemental2:elemental2-core:1.1.0/stripped_sources in 55ms
[INFO] Starting com.google.jsinterop:jsinterop-annotations:2.0.0/stripped_sources
[INFO] Starting com.google.elemental2:elemental2-dom:1.1.0/stripped_sources
[INFO] Finished org.dominokit:domino-jackson-processor:1.0.0-RC3/bytecode in 4119ms
[INFO] Finished com.google.elemental2:elemental2-dom:1.1.0/stripped_sources in 478ms
[INFO] Starting org.dominokit.i18n:gwt-datetimeformat:1.0/stripped_sources
[INFO] Finished org.dominokit.i18n:gwt-datetimeformat:1.0/stripped_sources in 19ms
[INFO] Starting org.dominokit:domino-jackson:1.0.0-RC3/stripped_sources
[INFO] Finished org.dominokit:domino-jackson:1.0.0-RC3/stripped_sources in 1127ms
[INFO] Starting org.dominokit:domino-jackson-processor:1.0.0-RC3/stripped_sources
[INFO] Starting org.dominokit:domino-jackson-super:1.0.0-RC3/stripped_bytecode
[INFO] Starting org.dominokit:domino-jackson-super:1.0.0-RC3/transpiled_js
[INFO] Starting com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/transpiled_js
[INFO] Finished org.dominokit:domino-jackson-super:1.0.0-RC3/stripped_bytecode in 2155ms
[INFO] Starting com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/stripped_bytecode
[INFO] Finished com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/stripped_bytecode in 704ms
[INFO] Starting com.google.jsinterop:jsinterop-annotations:2.0.0/transpiled_js
[INFO] Starting com.google.jsinterop:jsinterop-annotations:2.0.0/stripped_bytecode
[INFO] Starting org.dominokit.i18n:gwt-cldr:1.0/transpiled_js
[INFO] Finished com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/transpiled_js in 3329ms
[INFO] Starting org.dominokit.i18n:gwt-cldr:1.0/stripped_bytecode
[INFO] Finished org.dominokit:domino-jackson-super:1.0.0-RC3/transpiled_js in 4303ms
[INFO] Starting org.dominokit:domino-jackson-super:1.0.0-RC3/stripped_bytecode_headers
[INFO] Finished org.dominokit:domino-jackson-super:1.0.0-RC3/stripped_bytecode_headers in 120ms
[INFO] Starting com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/stripped_bytecode_headers
[INFO] Finished com.vertispan.jsinterop:base:1.0.0-SNAPSHOT/stripped_bytecode_headers in 20ms
[INFO] Starting com.google.jsinterop:jsinterop-annotations:2.0.0/stripped_bytecode_headers
[INFO] Starting com.google.elemental2:elemental2-promise:1.1.0/stripped_bytecode
[INFO] com.google.elemental2:elemental2-promise:1.1.0/stripped_bytecode: LOCALDIR\j2cl-problem\j2cl-domino-jackson-bug\target\gwt3BuildCache\0.19-SNAPSHOT\com.google.elemental2-elemental2-promise-1.1.0\b9a9c421dcc5a5ad53af6450b3f7ae6a-stripped_sources\results\elemental2\promise\Promise.java uses unchecked or unsafe operations.
[INFO] com.google.elemental2:elemental2-promise:1.1.0/stripped_bytecode: Recompile with -Xlint:unchecked for details.
[INFO] Finished com.google.elemental2:elemental2-promise:1.1.0/stripped_bytecode in 276ms
[INFO] Starting com.google.elemental2:elemental2-promise:1.1.0/transpiled_js
[INFO] Finished com.google.elemental2:elemental2-promise:1.1.0/transpiled_js in 487ms
[INFO] Starting com.google.elemental2:elemental2-promise:1.1.0/stripped_bytecode_headers
[INFO] Finished com.google.elemental2:elemental2-promise:1.1.0/stripped_bytecode_headers in 25ms
[INFO] Starting com.google.elemental2:elemental2-core:1.1.0/transpiled_js
[INFO] Finished org.dominokit.i18n:gwt-cldr:1.0/bytecode in 15222ms
[INFO] Finished com.google.elemental2:elemental2-core:1.1.0/transpiled_js in 5230ms
[INFO] Starting com.google.elemental2:elemental2-core:1.1.0/stripped_bytecode
[INFO] com.google.elemental2:elemental2-core:1.1.0/stripped_bytecode: LOCALDIR\j2cl-problem\j2cl-domino-jackson-bug\target\gwt3BuildCache\0.19-SNAPSHOT\com.google.elemental2-elemental2-core-1.1.0\4ee56d58cd973f29c315b0e308cfff8c-stripped_sources\results\elemental2\core\JsArray.java uses unchecked or unsafe operations.
[INFO] com.google.elemental2:elemental2-core:1.1.0/stripped_bytecode: Recompile with -Xlint:unchecked for details.
[INFO] Finished com.google.elemental2:elemental2-core:1.1.0/stripped_bytecode in 3007ms
[INFO] Starting com.google.elemental2:elemental2-core:1.1.0/stripped_bytecode_headers
[INFO] Finished com.google.elemental2:elemental2-core:1.1.0/stripped_bytecode_headers in 510ms
[INFO] Starting com.google.elemental2:elemental2-dom:1.1.0/stripped_bytecode
[INFO] com.google.elemental2:elemental2-dom:1.1.0/stripped_bytecode: Some input files use or override a deprecated API.
[INFO] com.google.elemental2:elemental2-dom:1.1.0/stripped_bytecode: Recompile with -Xlint:deprecation for details.
[INFO] Finished com.google.elemental2:elemental2-dom:1.1.0/stripped_bytecode in 9138ms
[INFO] Starting com.google.elemental2:elemental2-dom:1.1.0/transpiled_js
[INFO] Starting com.google.elemental2:elemental2-dom:1.1.0/stripped_bytecode_headers
[INFO] Finished com.google.elemental2:elemental2-dom:1.1.0/stripped_bytecode_headers in 7184ms
[INFO] Starting com.example:j2cl-domino-jackson-bug:0.0.1-SNAPSHOT/bytecode
[INFO] Finished com.example:j2cl-domino-jackson-bug:0.0.1-SNAPSHOT/bytecode in 1456ms
[INFO] Starting com.google.elemental2:elemental2-webgl:1.1.0/transpiled_js
[INFO] Finished com.google.elemental2:elemental2-webgl:1.1.0/transpiled_js in 3271ms
[INFO] Starting com.google.elemental2:elemental2-webgl:1.1.0/stripped_bytecode
[INFO] Finished com.google.elemental2:elemental2-webgl:1.1.0/stripped_bytecode in 1357ms
[INFO] Starting com.example:j2cl-domino-jackson-bug:0.0.1-SNAPSHOT/generated_sources
[INFO] Starting com.google.elemental2:elemental2-webgl:1.1.0/stripped_bytecode_headers
[INFO] Finished com.google.elemental2:elemental2-webgl:1.1.0/stripped_bytecode_headers in 165ms
[INFO] Starting com.example:j2cl-domino-jackson-bug:0.0.1-SNAPSHOT/stripped_sources
[INFO] Finished com.example:j2cl-domino-jackson-bug:0.0.1-SNAPSHOT/stripped_sources in 10ms
[INFO] Finished com.google.elemental2:elemental2-dom:1.1.0/transpiled_js in 18474ms
[INFO] org.dominokit.i18n:gwt-cldr:1.0/stripped_bytecode: LOCALDIR\j2cl-problem\j2cl-domino-jackson-bug\target\gwt3BuildCache\0.19-SNAPSHOT\org.dominokit.i18n-gwt-cldr-1.0\d2549c1dcff9b545270099de3262890c-stripped_sources\results\org\gwtproject\i18n\shared\cldr\DefaultCurrencyData.java uses or overrides a deprecated API.
[INFO] org.dominokit.i18n:gwt-cldr:1.0/stripped_bytecode: Recompile with -Xlint:deprecation for details.
[INFO] Finished org.dominokit.i18n:gwt-cldr:1.0/stripped_bytecode in 63666ms
[INFO] Starting org.dominokit.i18n:gwt-cldr:1.0/stripped_bytecode_headers
[INFO] Finished org.dominokit.i18n:gwt-cldr:1.0/stripped_bytecode_headers in 3566ms
[INFO] Starting org.dominokit.i18n:gwt-i18n:1.0/transpiled_js
[INFO] Starting org.dominokit.i18n:gwt-i18n:1.0/stripped_bytecode
[INFO] Finished org.dominokit.i18n:gwt-i18n:1.0/stripped_bytecode in 716ms
[INFO] Starting org.dominokit.i18n:gwt-i18n:1.0/stripped_bytecode_headers
[INFO] Finished org.dominokit.i18n:gwt-i18n:1.0/transpiled_js in 883ms
[INFO] Finished org.dominokit.i18n:gwt-i18n:1.0/stripped_bytecode_headers in 95ms
[INFO] Starting org.dominokit.i18n:gwt-datetimeformat:1.0/stripped_bytecode
[INFO] Starting org.dominokit.i18n:gwt-datetimeformat:1.0/transpiled_js
[INFO] Finished org.dominokit.i18n:gwt-datetimeformat:1.0/stripped_bytecode in 1371ms
[INFO] Finished org.dominokit.i18n:gwt-datetimeformat:1.0/transpiled_js in 1355ms
[INFO] Starting org.dominokit.i18n:gwt-datetimeformat:1.0/stripped_bytecode_headers
[INFO] Finished org.dominokit.i18n:gwt-datetimeformat:1.0/stripped_bytecode_headers in 35ms
[INFO] Starting org.dominokit:domino-jackson:1.0.0-RC3/transpiled_js
[INFO] Starting org.dominokit:domino-jackson:1.0.0-RC3/stripped_bytecode
[ERROR] Exception executing task org.dominokit:domino-jackson:1.0.0-RC3/transpiled_js
com.google.j2cl.common.visitor.ProcessorError: Context:

void BaseCollectionJsonDeserializer.setBackReference(String referenceName, Object reference, C value, JsonDeserializationContext ctx) {
  if (((null != value) && !value.isEmpty())) {
    for (T val : value) {
      BaseCollectionJsonDeserializer.this.deserializer.setBackReference(referenceName,reference,val,ctx);
    }
  }
}

    at com.google.j2cl.transpiler.ast.Visitor_ForEachStatement.visit (Visitor_ForEachStatement.java:27)
    at com.google.j2cl.transpiler.ast.ForEachStatement.accept (ForEachStatement.java:66)
    at com.google.j2cl.transpiler.ast.Visitor_Block.lambda$visitMembers$0 (Visitor_Block.java:47)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visitMembers (Visitor_Block.java:45)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visit (Visitor_Block.java:19)
    at com.google.j2cl.transpiler.ast.Block.accept (Block.java:55)
    at com.google.j2cl.transpiler.ast.Visitor_IfStatement.visitMembers (Visitor_IfStatement.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_IfStatement.visit (Visitor_IfStatement.java:19)
    at com.google.j2cl.transpiler.ast.IfStatement.accept (IfStatement.java:66)
    at com.google.j2cl.transpiler.ast.Visitor_Block.lambda$visitMembers$0 (Visitor_Block.java:47)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visitMembers (Visitor_Block.java:45)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visit (Visitor_Block.java:19)
    at com.google.j2cl.transpiler.ast.Block.accept (Block.java:55)
    at com.google.j2cl.transpiler.ast.Visitor_Method.visitMembers (Visitor_Method.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_Method.visit (Visitor_Method.java:19)
    at com.google.j2cl.transpiler.ast.Method.accept (Method.java:155)
    at com.google.j2cl.transpiler.ast.Visitor_Type.lambda$visitMembers$0 (Visitor_Type.java:51)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_Type.visitMembers (Visitor_Type.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_Type.visit (Visitor_Type.java:19)
    at com.google.j2cl.transpiler.ast.Type.accept (Type.java:318)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.lambda$visitMembers$0 (Visitor_CompilationUnit.java:51)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.visitMembers (Visitor_CompilationUnit.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.visit (Visitor_CompilationUnit.java:19)
    at com.google.j2cl.transpiler.ast.CompilationUnit.accept (CompilationUnit.java:93)
    at com.google.j2cl.transpiler.passes.NormalizeForEachStatement.applyTo (NormalizeForEachStatement.java:53)
    at com.google.j2cl.transpiler.passes.NormalizationPass$1.enterCompilationUnit (NormalizationPass.java:31)
    at com.google.j2cl.transpiler.ast.AbstractVisitor.shouldProcessCompilationUnit (AbstractVisitor.java:62)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.visit (Visitor_CompilationUnit.java:17)
    at com.google.j2cl.transpiler.ast.CompilationUnit.accept (CompilationUnit.java:93)
    at com.google.j2cl.transpiler.passes.NormalizationPass.execute (NormalizationPass.java:41)
    at com.google.j2cl.transpiler.J2clTranspiler.runPasses (J2clTranspiler.java:110)
    at com.google.j2cl.transpiler.J2clTranspiler.desugarLibrary (J2clTranspiler.java:88)
    at com.google.j2cl.transpiler.J2clTranspiler.transpileImpl (J2clTranspiler.java:80)
    at com.google.j2cl.transpiler.J2clTranspiler.lambda$transpile$0 (J2clTranspiler.java:44)
    at java.util.concurrent.Executors$RunnableAdapter.call (Executors.java:515)
    at java.util.concurrent.FutureTask.run (FutureTask.java:264)
    at java.util.concurrent.ThreadPoolExecutor.runWorker (ThreadPoolExecutor.java:1130)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run (ThreadPoolExecutor.java:630)
    at java.lang.Thread.run (Thread.java:832)
Caused by: com.google.j2cl.common.visitor.ProcessorError: Error while processing:

for (T val : value) {
  BaseCollectionJsonDeserializer.this.deserializer.setBackReference(referenceName,reference,val,ctx);
}

    at com.google.j2cl.transpiler.ast.Visitor_ForEachStatement.visit (Visitor_ForEachStatement.java:27)
    at com.google.j2cl.transpiler.ast.ForEachStatement.accept (ForEachStatement.java:66)
    at com.google.j2cl.transpiler.ast.Visitor_Block.lambda$visitMembers$0 (Visitor_Block.java:47)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visitMembers (Visitor_Block.java:45)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visit (Visitor_Block.java:19)
    at com.google.j2cl.transpiler.ast.Block.accept (Block.java:55)
    at com.google.j2cl.transpiler.ast.Visitor_IfStatement.visitMembers (Visitor_IfStatement.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_IfStatement.visit (Visitor_IfStatement.java:19)
    at com.google.j2cl.transpiler.ast.IfStatement.accept (IfStatement.java:66)
    at com.google.j2cl.transpiler.ast.Visitor_Block.lambda$visitMembers$0 (Visitor_Block.java:47)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visitMembers (Visitor_Block.java:45)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visit (Visitor_Block.java:19)
    at com.google.j2cl.transpiler.ast.Block.accept (Block.java:55)
    at com.google.j2cl.transpiler.ast.Visitor_Method.visitMembers (Visitor_Method.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_Method.visit (Visitor_Method.java:19)
    at com.google.j2cl.transpiler.ast.Method.accept (Method.java:155)
    at com.google.j2cl.transpiler.ast.Visitor_Type.lambda$visitMembers$0 (Visitor_Type.java:51)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_Type.visitMembers (Visitor_Type.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_Type.visit (Visitor_Type.java:19)
    at com.google.j2cl.transpiler.ast.Type.accept (Type.java:318)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.lambda$visitMembers$0 (Visitor_CompilationUnit.java:51)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.visitMembers (Visitor_CompilationUnit.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.visit (Visitor_CompilationUnit.java:19)
    at com.google.j2cl.transpiler.ast.CompilationUnit.accept (CompilationUnit.java:93)
    at com.google.j2cl.transpiler.passes.NormalizeForEachStatement.applyTo (NormalizeForEachStatement.java:53)
    at com.google.j2cl.transpiler.passes.NormalizationPass$1.enterCompilationUnit (NormalizationPass.java:31)
    at com.google.j2cl.transpiler.ast.AbstractVisitor.shouldProcessCompilationUnit (AbstractVisitor.java:62)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.visit (Visitor_CompilationUnit.java:17)
    at com.google.j2cl.transpiler.ast.CompilationUnit.accept (CompilationUnit.java:93)
    at com.google.j2cl.transpiler.passes.NormalizationPass.execute (NormalizationPass.java:41)
    at com.google.j2cl.transpiler.J2clTranspiler.runPasses (J2clTranspiler.java:110)
    at com.google.j2cl.transpiler.J2clTranspiler.desugarLibrary (J2clTranspiler.java:88)
    at com.google.j2cl.transpiler.J2clTranspiler.transpileImpl (J2clTranspiler.java:80)
    at com.google.j2cl.transpiler.J2clTranspiler.lambda$transpile$0 (J2clTranspiler.java:44)
    at java.util.concurrent.Executors$RunnableAdapter.call (Executors.java:515)
    at java.util.concurrent.FutureTask.run (FutureTask.java:264)
    at java.util.concurrent.ThreadPoolExecutor.runWorker (ThreadPoolExecutor.java:1130)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run (ThreadPoolExecutor.java:630)
    at java.lang.Thread.run (Thread.java:832)
Caused by: java.lang.ClassCastException: class com.google.j2cl.transpiler.ast.AutoValue_TypeVariable cannot be cast to class com.google.j2cl.transpiler.ast.DeclaredTypeDescriptor (com.google.j2cl.transpiler.ast.AutoValue_TypeVariable and com.google.j2cl.transpiler.ast.DeclaredTypeDescriptor are in unnamed module of loader org.codehaus.plexus.classworlds.realm.ClassRealm @5c7dfc05)
    at com.google.j2cl.transpiler.ast.TypeDescriptor.toBoxedType (TypeDescriptor.java:149)
    at com.google.j2cl.transpiler.passes.NormalizeForEachStatement.maybeAddCast (NormalizeForEachStatement.java:260)
    at com.google.j2cl.transpiler.passes.NormalizeForEachStatement.convertForEachIterable (NormalizeForEachStatement.java:183)
    at com.google.j2cl.transpiler.passes.NormalizeForEachStatement.access$100 (NormalizeForEachStatement.java:43)
    at com.google.j2cl.transpiler.passes.NormalizeForEachStatement$1.rewriteForEachStatement (NormalizeForEachStatement.java:62)
    at com.google.j2cl.transpiler.passes.NormalizeForEachStatement$1.rewriteForEachStatement (NormalizeForEachStatement.java:54)
    at com.google.j2cl.transpiler.ast.AbstractRewriter.postProcessForEachStatement (AbstractRewriter.java:375)
    at com.google.j2cl.transpiler.ast.Visitor_ForEachStatement.visit (Visitor_ForEachStatement.java:22)
    at com.google.j2cl.transpiler.ast.ForEachStatement.accept (ForEachStatement.java:66)
    at com.google.j2cl.transpiler.ast.Visitor_Block.lambda$visitMembers$0 (Visitor_Block.java:47)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visitMembers (Visitor_Block.java:45)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visit (Visitor_Block.java:19)
    at com.google.j2cl.transpiler.ast.Block.accept (Block.java:55)
    at com.google.j2cl.transpiler.ast.Visitor_IfStatement.visitMembers (Visitor_IfStatement.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_IfStatement.visit (Visitor_IfStatement.java:19)
    at com.google.j2cl.transpiler.ast.IfStatement.accept (IfStatement.java:66)
    at com.google.j2cl.transpiler.ast.Visitor_Block.lambda$visitMembers$0 (Visitor_Block.java:47)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visitMembers (Visitor_Block.java:45)
    at com.google.j2cl.transpiler.ast.Visitor_Block.visit (Visitor_Block.java:19)
    at com.google.j2cl.transpiler.ast.Block.accept (Block.java:55)
    at com.google.j2cl.transpiler.ast.Visitor_Method.visitMembers (Visitor_Method.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_Method.visit (Visitor_Method.java:19)
    at com.google.j2cl.transpiler.ast.Method.accept (Method.java:155)
    at com.google.j2cl.transpiler.ast.Visitor_Type.lambda$visitMembers$0 (Visitor_Type.java:51)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_Type.visitMembers (Visitor_Type.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_Type.visit (Visitor_Type.java:19)
    at com.google.j2cl.transpiler.ast.Type.accept (Type.java:318)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.lambda$visitMembers$0 (Visitor_CompilationUnit.java:51)
    at com.google.j2cl.common.visitor.ListVisitor.visit (ListVisitor.java:26)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.visitMembers (Visitor_CompilationUnit.java:49)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.visit (Visitor_CompilationUnit.java:19)
    at com.google.j2cl.transpiler.ast.CompilationUnit.accept (CompilationUnit.java:93)
    at com.google.j2cl.transpiler.passes.NormalizeForEachStatement.applyTo (NormalizeForEachStatement.java:53)
    at com.google.j2cl.transpiler.passes.NormalizationPass$1.enterCompilationUnit (NormalizationPass.java:31)
    at com.google.j2cl.transpiler.ast.AbstractVisitor.shouldProcessCompilationUnit (AbstractVisitor.java:62)
    at com.google.j2cl.transpiler.ast.Visitor_CompilationUnit.visit (Visitor_CompilationUnit.java:17)
    at com.google.j2cl.transpiler.ast.CompilationUnit.accept (CompilationUnit.java:93)
    at com.google.j2cl.transpiler.passes.NormalizationPass.execute (NormalizationPass.java:41)
    at com.google.j2cl.transpiler.J2clTranspiler.runPasses (J2clTranspiler.java:110)
    at com.google.j2cl.transpiler.J2clTranspiler.desugarLibrary (J2clTranspiler.java:88)
    at com.google.j2cl.transpiler.J2clTranspiler.transpileImpl (J2clTranspiler.java:80)
    at com.google.j2cl.transpiler.J2clTranspiler.lambda$transpile$0 (J2clTranspiler.java:44)
    at java.util.concurrent.Executors$RunnableAdapter.call (Executors.java:515)
    at java.util.concurrent.FutureTask.run (FutureTask.java:264)
    at java.util.concurrent.ThreadPoolExecutor.runWorker (ThreadPoolExecutor.java:1130)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run (ThreadPoolExecutor.java:630)
    at java.lang.Thread.run (Thread.java:832)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:59 min
[INFO] Finished at: 2022-02-06T09:08:06+01:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal com.vertispan.j2cl:j2cl-maven-plugin:0.19-SNAPSHOT:build (build-js) on project j2cl-domino-jackson-bug: Build failed, check log for failures -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```


