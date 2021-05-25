function arrayDemo() {
    /* Array Declare */
    console.log("Declaring Array");
    let values = ['a', 'b', 'c', 'd'];
    console.log("Printing Array");

    
    /* Array Parsing - Simple for Loop */
    console.log ("Parsing Array Using Simple For Loop")
    for (let i = 0; i < values.length; i++) {
        console.log("Element in Index " + i + " is: " + values[i]);
    }

    /* Array Parsing - For Each Method */
    console.log ("Parsing Array Using For Each Method")
    let i = -1;
    values.forEach(
        function (element){
            i ++;
            console.log("Element in Index " + i + " is: " + values[i]);
        }

    );

    /* Array Parsing - For Each Method - Another Signature */
    values.forEach(
        function (item, index){
            console.log("Element in Index " + index + " is: " + item);
        }

    );


    /* Return all the value matching criteria */
    console.log('Filtering Array')
    values = ['d', 'a', 'c', 'b'];
    const set = values.filter(function(element) {
        return element > 'a';
    });
    console.log('Filtered value is: '+set)

    /* Return the first value matching criteria */
    console.log('Filtering Array - First Matching Value')
    let filteredData = values.find(
        function(element){
            return element > 'b';
        }

    );
    console.log("Filtered Value: "+filteredData);

    /* Array Length */
    console.log("Length of the Array is "+ values.length)

    /* Push and Pop */
    console.log("Adding Element in the End")
    values.push('g', 'e', 'f');
    console.log("Array After Push: "+values )

    console.log("Removing Element from the End "+values.pop())
    console.log("Array After Pop: "+values )

    /* Shift and Unshift */
    console.log("Adding Element in the Beginning")
    values.unshift('z', 'y', 'x');
    console.log("Array After Unshift: "+values )

    console.log("Removing Element from the Beginning "+values.shift())
    console.log("Array After Shift: "+values )

    /* Slice and Splice */
    console.log("Sliced Array: "+values.slice(1,3));

    let newArray4 = values.splice(1,1);
    console.log("Spliced Array: "+values);

    newArray4 = values.splice(1,1, 'bb');
    console.log("Spliced Array: "+values);

    /* Remove an item by index position */
    let removedItem = values.splice(2, 1);
    console.log("Array After Removing 2nd Element: "+values)

    /* Access Element using Index */
    console.log("First Element is: "+values[0]);
    console.log("Last Element is: "+values[values.length -1]);
    console.log("Third Element is: "+values[2]);

    /* Retrieve Index using Element */
    console.log("Index of a is: "+values.indexOf('a'));

    /* Array Copy */
    let valuescopy = values.slice();
    console.log("Copied Array is "+valuescopy);

    /* Array Concat */
    let arr1 = ['a', 'b', 'c'];
    let arr2 = ['d', 'e', 'f'];
    const arr3 = arr1.concat(arr2);
    console.log("Concat Array is "+arr3)

}