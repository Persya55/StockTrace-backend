error id: file:///C:/Users/User/OneDrive/Documentos/Ciclo%207/Lenguajes%20Programación/StockTrack-Backend/stocktrack-backend/src/main/java/com/stocktrack/repository/MovimientoLoteRepository.java
file:///C:/Users/User/OneDrive/Documentos/Ciclo%207/Lenguajes%20Programación/StockTrack-Backend/stocktrack-backend/src/main/java/com/stocktrack/repository/MovimientoLoteRepository.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[6,43]

error in qdox parser
file content:
```java
offset: 147
uri: file:///C:/Users/User/OneDrive/Documentos/Ciclo%207/Lenguajes%20Programación/StockTrack-Backend/stocktrack-backend/src/main/java/com/stocktrack/repository/MovimientoLoteRepository.java
text:
```scala
package com.stocktrack.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoLoteRepository e@@{
    
}

```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:546)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:677)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:674)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:674)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:918)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1583)
```
#### Short summary: 

QDox parse error in file:///C:/Users/User/OneDrive/Documentos/Ciclo%207/Lenguajes%20Programación/StockTrack-Backend/stocktrack-backend/src/main/java/com/stocktrack/repository/MovimientoLoteRepository.java