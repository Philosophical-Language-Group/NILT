// Compiled by ClojureScript 1.10.439 {}
goog.provide('adzerk.boot_reload.reload');
goog.require('cljs.core');
goog.require('clojure.string');
goog.require('goog.Uri');
goog.require('goog.async.DeferredList');
goog.require('goog.html.legacyconversions');
goog.require('goog.net.jsloader');
adzerk.boot_reload.reload.page_uri = (function adzerk$boot_reload$reload$page_uri(){
return (new goog.Uri(window.location.href));
});
adzerk.boot_reload.reload.ends_with_QMARK_ = (function adzerk$boot_reload$reload$ends_with_QMARK_(s,pat){
return cljs.core._EQ_.call(null,pat,cljs.core.subs.call(null,s,(cljs.core.count.call(null,s) - cljs.core.count.call(null,pat))));
});
adzerk.boot_reload.reload.reload_page_BANG_ = (function adzerk$boot_reload$reload$reload_page_BANG_(){
return window.location.reload();
});
adzerk.boot_reload.reload.normalize_href_or_uri = (function adzerk$boot_reload$reload$normalize_href_or_uri(href_or_uri){
var uri = (new goog.Uri(href_or_uri));
return adzerk.boot_reload.reload.page_uri.call(null).resolve(uri).getPath();
});
/**
 * Produce the changed goog.Uri iff the (relative) path is different
 *   compared to the content of changed (a string). Return nil otherwise.
 */
adzerk.boot_reload.reload.changed_uri = (function adzerk$boot_reload$reload$changed_uri(href_or_uri,changed){
if(cljs.core.truth_(href_or_uri)){
var path = adzerk.boot_reload.reload.normalize_href_or_uri.call(null,href_or_uri);
var temp__5457__auto__ = cljs.core.first.call(null,cljs.core.filter.call(null,((function (path){
return (function (p1__1468_SHARP_){
return adzerk.boot_reload.reload.ends_with_QMARK_.call(null,adzerk.boot_reload.reload.normalize_href_or_uri.call(null,p1__1468_SHARP_),path);
});})(path))
,changed));
if(cljs.core.truth_(temp__5457__auto__)){
var changed__$1 = temp__5457__auto__;
return goog.Uri.parse(changed__$1);
} else {
return null;
}
} else {
return null;
}
});
adzerk.boot_reload.reload.reload_css = (function adzerk$boot_reload$reload$reload_css(changed){
var sheets = document.styleSheets;
var seq__1469 = cljs.core.seq.call(null,cljs.core.range.call(null,(0),sheets.length));
var chunk__1470 = null;
var count__1471 = (0);
var i__1472 = (0);
while(true){
if((i__1472 < count__1471)){
var s = cljs.core._nth.call(null,chunk__1470,i__1472);
var temp__5457__auto___1473 = (sheets[s]);
if(cljs.core.truth_(temp__5457__auto___1473)){
var sheet_1474 = temp__5457__auto___1473;
var temp__5457__auto___1475__$1 = adzerk.boot_reload.reload.changed_uri.call(null,sheet_1474.href,changed);
if(cljs.core.truth_(temp__5457__auto___1475__$1)){
var href_uri_1476 = temp__5457__auto___1475__$1;
sheet_1474.ownerNode.href = href_uri_1476.makeUnique().toString();
} else {
}
} else {
}


var G__1477 = seq__1469;
var G__1478 = chunk__1470;
var G__1479 = count__1471;
var G__1480 = (i__1472 + (1));
seq__1469 = G__1477;
chunk__1470 = G__1478;
count__1471 = G__1479;
i__1472 = G__1480;
continue;
} else {
var temp__5457__auto__ = cljs.core.seq.call(null,seq__1469);
if(temp__5457__auto__){
var seq__1469__$1 = temp__5457__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__1469__$1)){
var c__4461__auto__ = cljs.core.chunk_first.call(null,seq__1469__$1);
var G__1481 = cljs.core.chunk_rest.call(null,seq__1469__$1);
var G__1482 = c__4461__auto__;
var G__1483 = cljs.core.count.call(null,c__4461__auto__);
var G__1484 = (0);
seq__1469 = G__1481;
chunk__1470 = G__1482;
count__1471 = G__1483;
i__1472 = G__1484;
continue;
} else {
var s = cljs.core.first.call(null,seq__1469__$1);
var temp__5457__auto___1485__$1 = (sheets[s]);
if(cljs.core.truth_(temp__5457__auto___1485__$1)){
var sheet_1486 = temp__5457__auto___1485__$1;
var temp__5457__auto___1487__$2 = adzerk.boot_reload.reload.changed_uri.call(null,sheet_1486.href,changed);
if(cljs.core.truth_(temp__5457__auto___1487__$2)){
var href_uri_1488 = temp__5457__auto___1487__$2;
sheet_1486.ownerNode.href = href_uri_1488.makeUnique().toString();
} else {
}
} else {
}


var G__1489 = cljs.core.next.call(null,seq__1469__$1);
var G__1490 = null;
var G__1491 = (0);
var G__1492 = (0);
seq__1469 = G__1489;
chunk__1470 = G__1490;
count__1471 = G__1491;
i__1472 = G__1492;
continue;
}
} else {
return null;
}
}
break;
}
});
adzerk.boot_reload.reload.reload_img = (function adzerk$boot_reload$reload$reload_img(changed){
var images = document.images;
var seq__1493 = cljs.core.seq.call(null,cljs.core.range.call(null,(0),images.length));
var chunk__1494 = null;
var count__1495 = (0);
var i__1496 = (0);
while(true){
if((i__1496 < count__1495)){
var s = cljs.core._nth.call(null,chunk__1494,i__1496);
var temp__5457__auto___1497 = (images[s]);
if(cljs.core.truth_(temp__5457__auto___1497)){
var image_1498 = temp__5457__auto___1497;
var temp__5457__auto___1499__$1 = adzerk.boot_reload.reload.changed_uri.call(null,image_1498.src,changed);
if(cljs.core.truth_(temp__5457__auto___1499__$1)){
var href_uri_1500 = temp__5457__auto___1499__$1;
image_1498.src = href_uri_1500.makeUnique().toString();
} else {
}
} else {
}


var G__1501 = seq__1493;
var G__1502 = chunk__1494;
var G__1503 = count__1495;
var G__1504 = (i__1496 + (1));
seq__1493 = G__1501;
chunk__1494 = G__1502;
count__1495 = G__1503;
i__1496 = G__1504;
continue;
} else {
var temp__5457__auto__ = cljs.core.seq.call(null,seq__1493);
if(temp__5457__auto__){
var seq__1493__$1 = temp__5457__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__1493__$1)){
var c__4461__auto__ = cljs.core.chunk_first.call(null,seq__1493__$1);
var G__1505 = cljs.core.chunk_rest.call(null,seq__1493__$1);
var G__1506 = c__4461__auto__;
var G__1507 = cljs.core.count.call(null,c__4461__auto__);
var G__1508 = (0);
seq__1493 = G__1505;
chunk__1494 = G__1506;
count__1495 = G__1507;
i__1496 = G__1508;
continue;
} else {
var s = cljs.core.first.call(null,seq__1493__$1);
var temp__5457__auto___1509__$1 = (images[s]);
if(cljs.core.truth_(temp__5457__auto___1509__$1)){
var image_1510 = temp__5457__auto___1509__$1;
var temp__5457__auto___1511__$2 = adzerk.boot_reload.reload.changed_uri.call(null,image_1510.src,changed);
if(cljs.core.truth_(temp__5457__auto___1511__$2)){
var href_uri_1512 = temp__5457__auto___1511__$2;
image_1510.src = href_uri_1512.makeUnique().toString();
} else {
}
} else {
}


var G__1513 = cljs.core.next.call(null,seq__1493__$1);
var G__1514 = null;
var G__1515 = (0);
var G__1516 = (0);
seq__1493 = G__1513;
chunk__1494 = G__1514;
count__1495 = G__1515;
i__1496 = G__1516;
continue;
}
} else {
return null;
}
}
break;
}
});
adzerk.boot_reload.reload.load_files = (function adzerk$boot_reload$reload$load_files(urls){
var opts = ({"cleanupWhenDone": true});
if((typeof goog !== 'undefined') && (typeof goog.net !== 'undefined') && (typeof goog.net.jsloader !== 'undefined') && (typeof goog.net.jsloader.safeLoadMany !== 'undefined')){
return goog.net.jsloader.safeLoadMany(cljs.core.clj__GT_js.call(null,cljs.core.map.call(null,((function (opts){
return (function (p1__1517_SHARP_){
return goog.html.legacyconversions.trustedResourceUrlFromString(p1__1517_SHARP_.toString());
});})(opts))
,urls)),opts);
} else {
if((typeof goog !== 'undefined') && (typeof goog.net !== 'undefined') && (typeof goog.net.jsloader !== 'undefined') && (typeof goog.net.jsloader.loadMany !== 'undefined')){
return goog.net.jsloader.loadMany(cljs.core.clj__GT_js.call(null,urls),opts);
} else {
throw cljs.core.ex_info.call(null,"jsloader/safeLoadMany not found",cljs.core.PersistentArrayMap.EMPTY);

}
}
});
adzerk.boot_reload.reload.reload_js = (function adzerk$boot_reload$reload$reload_js(changed,p__1520){
var map__1521 = p__1520;
var map__1521__$1 = (((((!((map__1521 == null))))?(((((map__1521.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__1521.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__1521):map__1521);
var on_jsload = cljs.core.get.call(null,map__1521__$1,new cljs.core.Keyword(null,"on-jsload","on-jsload",-395756602),cljs.core.identity);
var js_files = cljs.core.filter.call(null,((function (map__1521,map__1521__$1,on_jsload){
return (function (p1__1518_SHARP_){
return adzerk.boot_reload.reload.ends_with_QMARK_.call(null,p1__1518_SHARP_,".js");
});})(map__1521,map__1521__$1,on_jsload))
,changed);
if(cljs.core.seq.call(null,js_files)){
adzerk.boot_reload.reload.load_files.call(null,cljs.core.map.call(null,((function (js_files,map__1521,map__1521__$1,on_jsload){
return (function (p1__1519_SHARP_){
return goog.Uri.parse(p1__1519_SHARP_).makeUnique();
});})(js_files,map__1521,map__1521__$1,on_jsload))
,js_files)).addCallbacks(((function (js_files,map__1521,map__1521__$1,on_jsload){
return (function() { 
var G__1523__delegate = function (_){
return on_jsload.call(null);
};
var G__1523 = function (var_args){
var _ = null;
if (arguments.length > 0) {
var G__1524__i = 0, G__1524__a = new Array(arguments.length -  0);
while (G__1524__i < G__1524__a.length) {G__1524__a[G__1524__i] = arguments[G__1524__i + 0]; ++G__1524__i;}
  _ = new cljs.core.IndexedSeq(G__1524__a,0,null);
} 
return G__1523__delegate.call(this,_);};
G__1523.cljs$lang$maxFixedArity = 0;
G__1523.cljs$lang$applyTo = (function (arglist__1525){
var _ = cljs.core.seq(arglist__1525);
return G__1523__delegate(_);
});
G__1523.cljs$core$IFn$_invoke$arity$variadic = G__1523__delegate;
return G__1523;
})()
;})(js_files,map__1521,map__1521__$1,on_jsload))
,((function (js_files,map__1521,map__1521__$1,on_jsload){
return (function (e){
return console.error("Load failed:",e.message);
});})(js_files,map__1521,map__1521__$1,on_jsload))
);

if(cljs.core.truth_((window["jQuery"]))){
return jQuery(document).trigger("page-load");
} else {
return null;
}
} else {
return null;
}
});
adzerk.boot_reload.reload.reload_html = (function adzerk$boot_reload$reload$reload_html(changed){
var page_path = adzerk.boot_reload.reload.page_uri.call(null).getPath();
var html_path = ((adzerk.boot_reload.reload.ends_with_QMARK_.call(null,page_path,"/"))?[cljs.core.str.cljs$core$IFn$_invoke$arity$1(page_path),"index.html"].join(''):page_path);
if(cljs.core.truth_(adzerk.boot_reload.reload.changed_uri.call(null,html_path,changed))){
return adzerk.boot_reload.reload.reload_page_BANG_.call(null);
} else {
return null;
}
});
adzerk.boot_reload.reload.group_log = (function adzerk$boot_reload$reload$group_log(title,things_to_log){
console.groupCollapsed(title);

var seq__1526_1530 = cljs.core.seq.call(null,things_to_log);
var chunk__1527_1531 = null;
var count__1528_1532 = (0);
var i__1529_1533 = (0);
while(true){
if((i__1529_1533 < count__1528_1532)){
var t_1534 = cljs.core._nth.call(null,chunk__1527_1531,i__1529_1533);
console.log(t_1534);


var G__1535 = seq__1526_1530;
var G__1536 = chunk__1527_1531;
var G__1537 = count__1528_1532;
var G__1538 = (i__1529_1533 + (1));
seq__1526_1530 = G__1535;
chunk__1527_1531 = G__1536;
count__1528_1532 = G__1537;
i__1529_1533 = G__1538;
continue;
} else {
var temp__5457__auto___1539 = cljs.core.seq.call(null,seq__1526_1530);
if(temp__5457__auto___1539){
var seq__1526_1540__$1 = temp__5457__auto___1539;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__1526_1540__$1)){
var c__4461__auto___1541 = cljs.core.chunk_first.call(null,seq__1526_1540__$1);
var G__1542 = cljs.core.chunk_rest.call(null,seq__1526_1540__$1);
var G__1543 = c__4461__auto___1541;
var G__1544 = cljs.core.count.call(null,c__4461__auto___1541);
var G__1545 = (0);
seq__1526_1530 = G__1542;
chunk__1527_1531 = G__1543;
count__1528_1532 = G__1544;
i__1529_1533 = G__1545;
continue;
} else {
var t_1546 = cljs.core.first.call(null,seq__1526_1540__$1);
console.log(t_1546);


var G__1547 = cljs.core.next.call(null,seq__1526_1540__$1);
var G__1548 = null;
var G__1549 = (0);
var G__1550 = (0);
seq__1526_1530 = G__1547;
chunk__1527_1531 = G__1548;
count__1528_1532 = G__1549;
i__1529_1533 = G__1550;
continue;
}
} else {
}
}
break;
}

return console.groupEnd();
});
/**
 * Perform heuristics to check if a non-shimmed DOM is available
 */
adzerk.boot_reload.reload.has_dom_QMARK_ = (function adzerk$boot_reload$reload$has_dom_QMARK_(){
return (((typeof window !== 'undefined')) && ((typeof window !== 'undefined') && (typeof window.document !== 'undefined')) && ((typeof window !== 'undefined') && (typeof window.document !== 'undefined') && (typeof window.document.documentURI !== 'undefined')));
});
adzerk.boot_reload.reload.reload = (function adzerk$boot_reload$reload$reload(changed,opts){
var changed_STAR_ = cljs.core.map.call(null,(function (p1__1551_SHARP_){
return [cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"asset-host","asset-host",-899289050).cljs$core$IFn$_invoke$arity$1(opts)),cljs.core.str.cljs$core$IFn$_invoke$arity$1(p1__1551_SHARP_)].join('');
}),cljs.core.map.call(null,(function (p__1552){
var map__1553 = p__1552;
var map__1553__$1 = (((((!((map__1553 == null))))?(((((map__1553.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__1553.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__1553):map__1553);
var canonical_path = cljs.core.get.call(null,map__1553__$1,new cljs.core.Keyword(null,"canonical-path","canonical-path",-1891747854));
var web_path = cljs.core.get.call(null,map__1553__$1,new cljs.core.Keyword(null,"web-path","web-path",594590673));
if(cljs.core._EQ_.call(null,"file:",(function (){var G__1555 = window;
var G__1555__$1 = (((G__1555 == null))?null:G__1555.location);
if((G__1555__$1 == null)){
return null;
} else {
return G__1555__$1.protocol;
}
})())){
return canonical_path;
} else {
return web_path;
}
}),changed));
adzerk.boot_reload.reload.group_log.call(null,"Reload",changed_STAR_);

adzerk.boot_reload.reload.reload_js.call(null,changed_STAR_,opts);

if(adzerk.boot_reload.reload.has_dom_QMARK_.call(null)){
var G__1556 = changed_STAR_;
adzerk.boot_reload.reload.reload_html.call(null,G__1556);

adzerk.boot_reload.reload.reload_css.call(null,G__1556);

adzerk.boot_reload.reload.reload_img.call(null,G__1556);

return G__1556;
} else {
return null;
}
});

//# sourceMappingURL=reload.js.map
