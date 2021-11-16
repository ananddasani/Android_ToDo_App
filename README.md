# Android_ToDo_App
A ToDo App Without Database

# Code

#### MainActivity.java
```
private ListView listView;
private Button button;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> ad;
    
    button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call the method to add items
                addItem(v);
            }
        });
        
arrayList = new ArrayList<>();
ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
    
//set the adapter
listView.setAdapter(ad);

    //long press to delete
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //context for toast
                Context context = getApplicationContext();
                Toast.makeText(context, "Item Removed", Toast.LENGTH_LONG).show();

                arrayList.remove(position);
                ad.notifyDataSetChanged();
                return true;
            }
        });
    }

    //Method to add items into ArrayList
    private void addItem(View v) {
        EditText fetchToDo = findViewById(R.id.fetchToDo);

        String itemByUser = fetchToDo.getText().toString();

        //if not null
        if(!(itemByUser.equals(""))){
            //add the item in array list
            ad.add(itemByUser);
            fetchToDo.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(), "Please Enter Text", Toast.LENGTH_SHORT).show();
        }
    }
```

# App Highlight

<img src="app_images/To Do Code.png" width="1000" /><br>

<img src="app_images/To Do List App.png" width="300" /><br>
