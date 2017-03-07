# Near-by-places-with-Intent

### gradle dependencies
```gradle
compile 'com.akhgupta:android-easylocation:1.0.1'
compile 'com.google.android.gms:play-services-location:10.2.0'
compile 'com.android.support:recyclerview-v7:25.2.0'
compile 'com.android.support:cardview-v7:25.2.0'
```


```java
  public void pop(Location location,Integer position){

        Uri gmmIntentUri = Uri.parse("geo:" + location.getLatitude() + "," + location.getLongitude() + "?q=" + names.get(position));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
```
