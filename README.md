# JavaThreads
Thread using in Java

Multiplying a matrix of size MxN (M rows, N columns) with another matrix of size NxP (N rows, P columns) (a result matrix of size MxP (M rows, P columns) is formed) With Java workpieces, it is wanted to do as follows: A part of the result matrix will be created by giving a row and the second matrix to a workpiece. In this way, the multiplication process will be completed by creating as many workpieces as the number of rows of the first matrix. The resulting matrix will be obtained by creating a part related to each workpiece in a buffer whose respective methods are defined synchronously.

Detail:
* Matrices will be given in text files named matrix1.txt and matrix2.txt, leaving a space between the numbers:

Matris1.txt   Matris2.txt
  2 8 9            6 5
  1 3 5            8 7 
  
Buffer class for the buffer zone. Let the Buffer class take the number of rows and columns for the result matrix in the constructor method and create the two dimensions of the result matrix according to these row and column numbers. It must have a put method in the buffer class; The put method can be used by the relevant thread to write a result into a cell of the result matrix. Define the put method as synchronized. You can specify the parameters of the put method accordingly. Also added a print method to print the entire result matrix.

Wrote a work piece (Thread) named MultiplyWorker. As stated in the general problem definition above, this workpiece can take the buffer, the corresponding row of the first matrix, the second matrix and other variables you need (such as row index if necessary) as parameters to the constructor method. In the run method, partial results will be obtained within the task of the relevant workpiece and will be transferred to the relevant places in the buffer.

By writing a test program, in the main method, take the two matrices that come from the files as input, created the buffer 'object and the workpiece as the number of rows of the first matrix and start the workpieces. Then, after waiting for all the workpieces to be finished, remove the buffer.
Printed it to end the main method.
