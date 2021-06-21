let arrayDemo = function () {

    // Integer Array
    let array1 = [1, 2, 3];
    console.log('Complete Array '+array1)
    for (let i in array1){
        console.log('Element Value '+array1[i])
    }

    // Strimg Array
    let array2 = Array.of('a', 'dd', 'bbb', 'cc');
    console.log('Complete Array '+array2);
    console.log('Index of Non-existent '+array2.indexOf('d'));

    // Parsing and Filtering Array
    for (let i in array2){
        console.log('Element Value '+array2[i]);
    }

    // Return all the value matching criteria
    const set = array2.filter(function(item) {
        return item > 'a';
    });
    console.log('Filtered value is: '+set)
    set.forEach(function (item){
        console.log("Items from For Each: "+item);

    });

    // Return the first value matching criteria
    let filteredData = array2.find(
        function(item){
            return item.length > 1;
        }

    );
    console.log("Filtered Value: "+filteredData);

    console.log("Length is "+array2.length);

    console.log("1st Element is: "+array2[1]);

    // Update Array Elements
    array2[1] = 'bb';
    console.log('Complete Array After Element Update '+array2);

    // Add New Element at the end
    array2.push('d', 'e');
    console.log('Complete Array After Push '+array2);

    // Add New Element at the beginning
    array2.unshift('0', '1');
    console.log('Complete Array After Unshift '+array2);

    // Access and Remove First Element
    console.log('First Element Shift: '+array2.shift());
    console.log('First Element Shift: '+array2.shift());
    console.log('Complete Array After Shift '+array2);

    // Access and Remove Last Element
    console.log('Last Element Pop: '+array2.pop());
    console.log('Last Element Pop: '+array2.pop());
    console.log('Complete Array After Pop '+array2);

    // Slice
    let array3 = ['a', 'b', 'c'];
    let newArray3 = array3.slice(0,2);
    console.log("Sliced Array: "+newArray3);

    // Splice
    let array4 = ['a', 'b', 'c', 'd'];
    let newArray4 = array4.splice(1,1);
    console.log("Spliced Array: "+array4);

    newArray4 = array4.splice(1,1, 'bb');
    console.log("Spliced Array: "+array4);


}


/*
push: add n number elements at the end of the array
pop: retrieves and removes the last element
shift: retrieves and removes the first element
unshift: add n number of elements at the beginning of the arrat


*/
