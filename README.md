# parallel-primes

This project was made for the High Performance Computing class. The aim is to create a program that can give all the primes number between two given numbers.
This program was tested with a computer running with a Ryzen 1400 with a clockspeed of 3.2 Ghz and 4 cores/ 8 threads.
The results given may vary depending on the computer wich is tested. 

First result calculating primes between 2 and 40 millions.

<table>
    <thead>
      <tr>
        <th>Number of threads</th>
        <th>Average time in mili seconds</th>
        <th>SpeedUp</th>
        <th>Efficency</th>
      </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>28554,5</td>
            <td>1</td>
            <td>100%</td>
        </tr>
        <tr>
            <td>2</td>
            <td>34517,75</td>
            <td>0,827241057</td>
            <td>41%</td>
        </tr>
        <tr>
            <td>3</td>
            <td>38666,375</td>
            <td>0,738484019</td>
            <td>25%</td>
        </tr>
        <tr>
            <td>4</td>
            <td>36115,375</td>
            <td>0,790646643</td>
            <td>20%</td>
        </tr>
        <tr>
            <td>5</td>
            <td>37894,875</td>
            <td>0,753518781</td>
            <td>15%</td>
        </tr>
        <tr>
            <td>6</td>
            <td>36331</td>
            <td>0,785954144</td>
            <td>13%</td>
        </tr>
        <tr>
            <td>7</td>
            <td>29492,5</td>
            <td>0,968195304</td>
            <td>14%</td>
        </tr>
        <tr>
            <td>8</td>
            <td>32651,5</td>
            <td>0,874523376</td>
            <td>11%</td>
        </tr>
    </tbody>
  </table>
Graphics

![](https://github.com/Nicolashex/parallel-primes/blob/main/speedupvseficiencia40mill.PNG?raw=true)

Second result calculating primes between 2 and 400 hundred thousand.

<table>
    <thead>
      <tr>
        <th>Number of threads</th>
        <th>Average time in mili seconds</th>
        <th>SpeedUp</th>
        <th>Efficency</th>
      </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>82,375</td>
            <td>1</td>
            <td>100%</td>
        </tr>
        <tr>
            <td>2</td>
            <td>79,625</td>
            <td>1,034536892</td>
            <td>52%</td>
        </tr>
        <tr>
            <td>3</td>
            <td>54,625</td>
            <td>1,508009153</td>
            <td>50%</td>
        </tr>
        <tr>
            <td>4</td>
            <td>54,375</td>
            <td>1,514942529</td>
            <td>38%</td>
        </tr>
        <tr>
            <td>5</td>
            <td>53,125</td>
            <td>1,550588235</td>
            <td>31%</td>
        </tr>
        <tr>
            <td>6</td>
            <td>58,75</td>
            <td>1,40212766</td>
            <td>23%</td>
        </tr>
        <tr>
            <td>7</td>
            <td>59</td>
            <td>1,396186441</td>
            <td>20%</td>
        </tr>
        <tr>
            <td>8</td>
            <td>57,125</td>
            <td>1,442013129</td>
            <td>18%</td>
        </tr>
    </tbody>
  </table>
Graphics

![](https://github.com/Nicolashex/parallel-primes/blob/main/speedupvseficiencia400mil.PNG?raw=true)

